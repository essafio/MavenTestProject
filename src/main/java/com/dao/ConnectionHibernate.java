package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface ConnectionHibernate {
    SessionFactory getSessionFactory();

    void closeSession();
}
