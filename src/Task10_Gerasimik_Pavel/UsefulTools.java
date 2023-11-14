package Task10_Gerasimik_Pavel;


import Task10_Gerasimik_Pavel.Comments.Comment;

import java.util.Collection;

public class UsefulTools {
    private UsefulTools() {

    }
    public static String regEx = "(?=[\\p{P}\\s])|(?<=[\\p{P}\\s])";

    public static <T> void commentsOutputInConsole(Collection<T> comments) {
        for (T comment : comments) {
            if (comment instanceof String) {
                System.out.println(comment);
            } else if (comment instanceof Comment) {
                System.out.println(((Comment) comment).getLabel());
            }
        }
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
    public static boolean isWordSimilar(String word1, String word2) {
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

    public static boolean isSameLength(String word1, String word2) {
        return word1.length() == word2.length();
    }

}
