package com.daoimpl;

import com.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionHibernateImpl implements com.dao.ConnectionHibernate {

    private static ConnectionHibernateImpl uniqueInstance = new ConnectionHibernateImpl();

    private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    //private Session session = factory.getCurrentSession();

    /* Pattern Singleton */
    public static ConnectionHibernateImpl getInstance(){
        return uniqueInstance;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void closeSession(){
        sessionFactory.close();
    }
}
