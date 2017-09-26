package com.daoimpl;

import com.beans.*;
import com.factory.Factory;
import org.hibernate.*;


public class UserDAOImpl implements com.dao.UserDAO {

    private static UserDAOImpl uniqueInstance = new UserDAOImpl();

    private Session session = Factory.getConnexionHibernate().getSession();

    public static UserDAOImpl getInstance() {
        return uniqueInstance;
    }

    public void addUser(User user){
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}
