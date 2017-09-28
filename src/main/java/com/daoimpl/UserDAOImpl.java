package com.daoimpl;

import com.beans.*;
import com.factory.Factory;
import org.hibernate.*;

import java.util.List;


public class UserDAOImpl implements com.dao.UserDAO {

    private static UserDAOImpl uniqueInstance = new UserDAOImpl();

    private SessionFactory sessionFactory = Factory.getConnexionHibernate().getSessionFactory();


    public static UserDAOImpl getInstance() {
        return uniqueInstance;
    }

    public User addUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    public User updateUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        return user;
    }

    public User getUser(Long id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return (User) session.load(User.class, id);
    }

    public List<User> getUsers(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.createCriteria(User.class).list();
    }

    public void deleteUser(Long id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.load(User.class, id));
        session.getTransaction().commit();
    }

}
