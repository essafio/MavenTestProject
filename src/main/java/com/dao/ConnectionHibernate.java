package com.dao;

import org.hibernate.Session;

public interface ConnectionHibernate {
    Session getSession();

    void closeSession();
}
