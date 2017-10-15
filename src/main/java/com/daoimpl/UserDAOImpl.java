package com.daoimpl;

import com.beans.*;
import com.factory.Factory;
import com.util.HibernateUtil;
import org.hibernate.*;

import java.util.List;


public class UserDAOImpl implements com.dao.UserDAO {

    private static UserDAOImpl uniqueInstance = new UserDAOImpl();
    //private SessionFactory sessionFactory = Factory.getConnexionHibernate().getSessionFactory();


    public static UserDAOImpl getInstance() {
        return uniqueInstance;
    }

    public User addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    public User updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }


    public User getUserByLogin(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User user = null;

        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from User u where username = :username and password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);

            List listResult = query.list();
            user = (User) listResult.get(0);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    public User getUser(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User user = null;

        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close(); //Not needed if we use getCurrentSession() instead of openSession()
        }

        return user;
    }

    public List<User> getUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<User> users = null;

        try {
            transaction = session.beginTransaction();
            users = session.createCriteria(User.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    public void deleteUser(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(session.load(User.class, id));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
