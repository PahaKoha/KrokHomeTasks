package Task9_Gerasimik_Pavel;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> comments = Comments.commentsList;
        Set<String> rudeWords = RudeWords.rudeWordsList;
        Set<String> correctWords = CorrectWords.correctWordList;

        Filter<WordHandler> filterForIncorrectWords = new Filter<>(new ToolsForIncorrectWords());
        Filter<WordHandler> filterForRudeWords = new Filter<>(new ToolsForRudeWords());

        filterForIncorrectWords.filterComments(comments, correctWords);
        filterForRudeWords.filterComments(comments, rudeWords);

        UsefulTools.commentsOutputInConsole(comments);
    }
}
