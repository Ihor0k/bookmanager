package ihor0k.service;

import ihor0k.DAO.CommentDAO;
import ihor0k.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentDAO commentDAO;

    @Override
    @Transactional
    public void addComment(Comment comment) {
        commentDAO.addComment(comment);
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        commentDAO.updateComment(comment);
    }

    @Override
    @Transactional
    public void removeComment(int id) {
        commentDAO.removeComment(id);
    }

    @Override
    @Transactional
    public Comment getComment(int id) {
        return commentDAO.getComment(id);
    }

    @Override
    @Transactional
    public List<Comment> getAllComments() {
        return commentDAO.getAllComments();
    }

    @Autowired
    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
}
