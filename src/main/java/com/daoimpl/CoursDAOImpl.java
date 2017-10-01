package com.daoimpl;

import com.beans.*;
import com.factory.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sun.rmi.log.LogInputStream;

import java.util.List;

public class CoursDAOImpl implements com.dao.CoursDAO {

    private static CoursDAOImpl uniqueInstance = new CoursDAOImpl();

    private SessionFactory sessionFactory = Factory.getConnexionHibernate().getSessionFactory();

    

    public static CoursDAOImpl getInstance() {
        return uniqueInstance;
    }
    

    public Cours addCours(Cours cours){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(cours);
        session.getTransaction().commit();
        session.close();
        return cours;
    }

    public Cours getCour(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Cours cours1 = (Cours) session.load(Cours.class, id);

//        Cours cours = new Cours();
//        cours.setName(cours1.getName());
//        cours.setCredits(cours1.getCredits());

        session.close();

        return cours1;
    }

    public List<Cours> getCours() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Cours> list =  session.createCriteria(Cours.class).list();
        session.close();
        return list;

    }

    public void deleteCours(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.load(Cours.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public Cours updateCours(Cours cours){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(cours);
        session.getTransaction().commit();
        session.close();
        return cours;

    }

}
