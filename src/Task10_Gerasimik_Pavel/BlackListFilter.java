package Task10_Gerasimik_Pavel;

import Task10_Gerasimik_Pavel.Comments.Comment;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface BlackListFilter<T> {
    default Collection<String> filterComments(Collection<T> comments, Predicate<String> predicate) {
        List<String> filteredComments = new ArrayList<>();

        for (T comment : comments) {
            String label = (comment instanceof String stringComment) ? stringComment : ((Comment) comment).getLabel();

            String filteredComment = Arrays.stream(label.split(UsefulTools.regEx))
                    .map(word -> predicate.test(word) ? UsefulTools.replaceWordWithStars(word) : word)
                    .collect(Collectors.joining());

            filteredComments.add(filteredComment);
        }

        return filteredComments;
    }
}
