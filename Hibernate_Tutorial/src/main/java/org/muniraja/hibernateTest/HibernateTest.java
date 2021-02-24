package org.muniraja.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.muniraja.dto.UserDetails;

public class HibernateTest {

    public static void main(String[] args){

        UserDetails user = new UserDetails();
        user.setUserId(10);
        user.setUserName("Muniraja");

        //Configuration().configure() reads hibernate.cfg.xml file and create one sf object per application
        //sf will have factory of session objects and all the transactions will happens through session
        //using session we will run crud operations on the database.
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

}
