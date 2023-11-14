package Task10_Gerasimik_Pavel;

import java.util.Set;
import java.util.function.Predicate;

public interface PredicateFactory {
    Predicate<String> createPredicateForBlackListFilter(Set<String> blackList);
}
