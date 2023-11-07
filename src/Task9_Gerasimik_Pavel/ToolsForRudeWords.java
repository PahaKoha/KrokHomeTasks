package Task9_Gerasimik_Pavel;

import java.util.List;
import java.util.Set;

public class ToolsForRudeWords implements WordHandler {
    @Override
    public String commentsHandler(List<String> words, Set<String> blackList) {
        StringBuilder correctedComment = new StringBuilder();
        for (String word : words) {
            if (blackList.contains(word.toLowerCase())) {
                word = UsefulTools.replaceWordWithStars(word);
            }
            correctedComment.append(word);
        }
        return correctedComment.toString();
    }
}
