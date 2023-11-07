package Task9_Gerasimik_Pavel;

import java.util.Arrays;
import java.util.List;

public class UsefulTools {
    public static List<String> getElementsFromComment(String comment) {
        String[] words = comment.split("(?=[\\p{P}\\s])|(?<=[\\p{P}\\s])");
        return Arrays.asList(words);
    }

    public static void commentsOutputInConsole(List<String> comments) {
        for (String comment : comments) {
            System.out.println(comment);
        }
    }

    public static boolean isSameLength(String word1, String word2) {
        return word1.length() == word2.length();
    }

    public static String replaceWordWithStars(String word) {
        char star = '*';
        return String.valueOf(star).repeat(word.length());
    }

    public static boolean isPunctuationOrSpace(String element) {
        if (element.length() == 1) {
            return Character.isWhitespace(element.charAt(0)) && Character.getType(element.charAt(0)) != Character.OTHER_PUNCTUATION;
        }
        return false;
    }
}
