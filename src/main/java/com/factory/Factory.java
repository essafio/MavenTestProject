package com.factory;

import com.dao.*;
import com.daoimpl.*;

public class Factory {

    public static ConnectionHibernate getConnexionHibernate()
    {
        return ConnectionHibernateImpl.getInstance();
    }

    public static UserDAO getUserDAO()
    {
        return UserDAOImpl.getInstance();
    }

    public static CoursDAO getCoursDAO()
    {
        return CoursDAOImpl.getInstance();
    }
}
