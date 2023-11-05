package Task9_Geasimik_Pavel;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> comments = Comments.commentsList;
        Set<String> rudeWords = RudeWords.rudeWordsList;

        BlackListFilter blackListFilter = new BlackListFilter() {
            @Override
            public void filterComments(List<String> comments, Set<String> blackList) {
                for (int i = 0; i < comments.size(); i++) {
                    List<String> words = getWordsFromComment(comments.get(i));
                    String newComment = findRudeWords(words, blackList);
                    comments.set(i, newComment.trim());
                }
            }
        };
        blackListFilter.filterComments(comments, rudeWords);
        commentsOutputInConsole(comments);
    }

    public static List<String> getWordsFromComment(String comment) {
        String[] words = comment.split("(?=[\\p{P}\\s])|(?<=[\\p{P}\\s])");
        return Arrays.asList(words);
    }

    public static String findRudeWords(List<String> words, Set<String> blackList) {
        StringBuilder newComment = new StringBuilder();
        for (String word : words) {
            if (blackList.contains(word)) {
                word = replaceWordWithStars(word);
            }
            newComment.append(word);
        }
        return newComment.toString();
    }

    public static void commentsOutputInConsole(List<String> comments) {
        for (String comment : comments) {
            System.out.println(comment);
        }
    }

    public static String replaceWordWithStars (String word) {
        char star = '*';
        return String.valueOf(star).repeat(word.length());
    }
}
