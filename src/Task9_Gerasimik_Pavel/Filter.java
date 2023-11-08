package Task9_Gerasimik_Pavel;

import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {

    private final WordHandler wordCorrection;

    public Filter(WordHandler wordCorrection) {
        this.wordCorrection = wordCorrection;
    }

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (int i = 0; i < comments.size(); i++) {
            List<String> words = UsefulTools.getElementsFromComment(comments.get(i));
            String newComment = wordCorrection.commentsHandler(words, blackList);
            comments.set(i, newComment.trim());

        }
    }
}
