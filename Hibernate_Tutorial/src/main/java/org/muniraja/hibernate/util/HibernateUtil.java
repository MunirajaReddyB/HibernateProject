package org.muniraja.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Configuration().configure() reads hibernate.cfg.xml file and creates one sf object per application
//sf will have factory of session objects and all the transactions will happens through session

public class HibernateUtil {

    private static volatile SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null){

            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}

