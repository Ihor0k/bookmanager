package ihor0k.DAO;

import ihor0k.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User details: " + user);
    }

    @Override
    public void removeUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where username = :username", User.class)
                .setParameter("username", username)
                .list().get(0);
        if (user != null)
            session.delete(user);
        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        logger.info("User successfully loaded. User details: " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        logger.info("User list size: " + userList.size() + " items");
        return userList;
    }
}
