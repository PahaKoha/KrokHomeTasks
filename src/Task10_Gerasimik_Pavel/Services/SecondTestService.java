package Task10_Gerasimik_Pavel.Services;

import Task10_Gerasimik_Pavel.BlackListFilter;
import Task10_Gerasimik_Pavel.PredicateFactory;
import Task10_Gerasimik_Pavel.UsefulTools;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Этот сервис обрабатывает как просто грубые слова, так и грубые слова, написанные с ошибкой.
 * @param <T> - формат комментариев. Для десятого задания я использовал обычные строки, а также специальныый класс, который хранит в себе комментарий.
 */
public class SecondTestService<T> implements BlackListFilter<T>, PredicateFactory {
    public Collection<String> filter(Set<T> comments, Set<String> blackList) {
        Predicate<String> predicate = createPredicateForBlackListFilter(blackList);
        return filterComments(comments, predicate);
    }

    @Override
    public Predicate<String> createPredicateForBlackListFilter(Set<String> blackList) {
        return str ->
                blackList.contains(str) || !UsefulTools.isPunctuationOrSpace(str) &&
                        blackList.stream()
                                .anyMatch(word -> UsefulTools.isSameLength(str, word) && UsefulTools.isWordSimilar(str, word)); // не знаю что это, но среда разработки сама предложила
    }
}
