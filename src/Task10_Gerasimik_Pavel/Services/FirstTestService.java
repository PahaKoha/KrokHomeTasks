package Task10_Gerasimik_Pavel.Services;

import Task10_Gerasimik_Pavel.BlackListFilter;
import Task10_Gerasimik_Pavel.PredicateFactory;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Этот сервис обрабатывает просто грубые слова.
 * @param <T> - формат комментариев, для десятого задания я использовал обычные строки, а также специальныый класс, еоторый хранил в себе комментарий.
 */
public class FirstTestService<T> implements BlackListFilter<T>, PredicateFactory {
    public Collection<String> filter (Set<T> comments, Set<String> blackList) {
        Predicate<String> predicate = createPredicateForBlackListFilter(blackList);
        return filterComments(comments, predicate);
    }

    @Override
    public Predicate<String> createPredicateForBlackListFilter(Set<String> blackList) {
         return blackList::contains;
    }
}
