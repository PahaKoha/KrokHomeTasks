package Task10_Gerasimik_Pavel;


import Task10_Gerasimik_Pavel.Comments.Comment;
import Task10_Gerasimik_Pavel.Comments.ListWithStringComments;
import Task10_Gerasimik_Pavel.Services.FirstTestService;
import Task10_Gerasimik_Pavel.Services.SecondTestService;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> blackList = RudeWords.rudeWordsList;
        Set<String> setWithStringComments = ListWithStringComments.commentsList;
        Set<Comment> setWithObjectsComments = Set.of(new Comment("дуралий"), new Comment("Ну ты и дурак конечно дурак!"));

        FirstTestService<String> firstServiceWithStringComments = new FirstTestService<>();
        UsefulTools.commentsOutputInConsole(firstServiceWithStringComments.filter(setWithStringComments, blackList));

        System.out.println("--------------------------");

        FirstTestService<Comment> firstServiceWithCommentObjects = new FirstTestService<>();
        UsefulTools.commentsOutputInConsole(firstServiceWithCommentObjects.filter(setWithObjectsComments, blackList));

        System.out.println("--------------------------");

        SecondTestService<String> secondServiceWithStringComments = new SecondTestService<>();
        UsefulTools.commentsOutputInConsole(secondServiceWithStringComments.filter(setWithStringComments, blackList));

        System.out.println("--------------------------");

        SecondTestService<Comment> secondServiceWithSCommentObjects = new SecondTestService<>();
        UsefulTools.commentsOutputInConsole(secondServiceWithSCommentObjects.filter(setWithObjectsComments, blackList));
    }
}
