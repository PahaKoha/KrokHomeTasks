package Task9_Gerasimik_Pavel;

import java.util.List;
import java.util.Set;

public class Filter<T extends WordHandler> implements BlackListFilter {

    private final T type;

    public Filter(T type) {
        this.type = type;
    }

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (int i = 0; i < comments.size(); i++) {
            List<String> words = UsefulTools.getElementsFromComment(comments.get(i));
            String newComment = type.commentsHandler(words, blackList);
            comments.set(i, newComment.trim());

        }
    }
}
