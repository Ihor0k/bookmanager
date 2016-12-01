package ihor0k.DAO;

import ihor0k.model.Comment;

import java.util.List;

public interface CommentDAO {
    void addComment(Comment comment);

    void updateComment(Comment comment);

    void removeComment(int id);

    Comment getComment(int id);

    List<Comment> getAllComments();
}