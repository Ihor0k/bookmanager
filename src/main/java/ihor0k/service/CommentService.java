package ihor0k.service;

import ihor0k.model.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);

    void updateComment(Comment comment);

    void removeComment(int id);

    Comment getComment(int id);

    List<Comment> getAllComments();
}
