package com.daoimpl;

import com.beans.*;
import com.factory.Factory;
import org.hibernate.Session;

public class CoursDAOImpl implements com.dao.CoursDAO {

    private static CoursDAOImpl uniqueInstance = new CoursDAOImpl();

    //private Session sessionFactory = Factory.getConnexionHibernate().getSessionFactory();

    public static CoursDAOImpl getInstance() {
        return uniqueInstance;
    }

    public void addCours(Cours cours){
        /*session.beginTransaction();
        session.save(cours);
        session.getTransaction().commit();*/
    }
}
