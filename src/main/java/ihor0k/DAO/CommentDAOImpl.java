package ihor0k.DAO;

import ihor0k.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {
    private static final Logger logger = LoggerFactory.getLogger(CommentDAOImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(comment);
        logger.info("Comment successfully saved. Comment details: " + comment);
    }

    @Override
    public void updateComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(comment);
        logger.info("Comment successfully updated. Comment details: " + comment);
    }

    @Override
    public void removeComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Comment comment = session.load(Comment.class, new Integer(id));
        if (comment != null)
            session.delete(comment);
        logger.info("Comment successfully removed. Comment details: " + comment);
    }

    @Override
    public Comment getComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Comment comment = session.load(Comment.class, new Integer(id));
        logger.info("Comment successfully loaded. Comment details: " + comment);
        return comment;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Comment> getAllComments() {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> commentList = session.createQuery("from Comment").list();
        logger.info("Comment list size: " + commentList.size() + " items");
        return commentList;
    }
}
