package com.daoimpl;

import com.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionHibernateImpl implements com.dao.ConnectionHibernate {

    private static ConnectionHibernateImpl uniqueInstance = new ConnectionHibernateImpl();

    private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
    private Session session = factory.getCurrentSession();

    /* Pattern Singleton */
    public static ConnectionHibernateImpl getInstance(){
        return uniqueInstance;
    }

    public Session getSession(){
        return session;
    }

    public void closeSession(){
        session.close();
    }
}
