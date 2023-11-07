package Task9_Gerasimik_Pavel;

import java.util.List;
import java.util.Set;

public class ToolsForIncorrectWords implements WordHandler {
    @Override
    public String commentsHandler(List<String> elementsFromComment, Set<String> listWithCorrectWords) {
        StringBuilder correctedComment = new StringBuilder();

        for (String word : elementsFromComment) {
            if (!listWithCorrectWords.contains(word.toLowerCase()) && !UsefulTools.isPunctuationOrSpace(word)) {
                String correctedWord = findSimilarWord(word, listWithCorrectWords);
                correctedComment.append(correctedWord);
            } else {
                correctedComment.append(word);
            }
        }

        return correctedComment.toString();
    }

    private static String findSimilarWord(String elementFromComment, Set<String> dictionary) {
        for (String word : dictionary) {
            if (UsefulTools.isSameLength(elementFromComment, word) && isWordSimilar(elementFromComment, word)) {
                return UsefulTools.replaceWordWithStars(elementFromComment);
            }
        }
        return elementFromComment;
    }

    private static boolean isWordSimilar(String word1, String word2) {
        int errorCounter = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.toLowerCase().charAt(i) != word2.toLowerCase().charAt(i)) {
                errorCounter++;
            }
            if (errorCounter > 1) {
                return false;
            }
        }

        return true;
    }
}
