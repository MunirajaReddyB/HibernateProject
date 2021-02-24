package org.muniraja.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.muniraja.dto.UserDetails;

import java.sql.SQLOutput;

public class HibernateTest {

    public static void main(String[] args){

        UserDetails user = new UserDetails();
        user.setUserId(10);
        user.setUserName("Vijay Devarakonda");

        UserDetails user1 = new UserDetails();
        user1.setUserId(12);
        user1.setUserName("Vijay Sethupathi");

        //Configuration().configure() reads hibernate.cfg.xml file and creates one sf object per application
        //sf will have factory of session objects and all the transactions will happens through session
        //using session we will run crud operations on the database.
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user1);
        session.getTransaction().commit();
        session.close();

        UserDetails userDetails = null;
        //retrieving objects from db using hibernate get() method
        Session session1 = sf.openSession();
        session1.beginTransaction();
        userDetails = (UserDetails) session1.get(UserDetails.class,12);
        System.out.println("UserId:"+userDetails.getUserId());
        System.out.println("UserName:"+userDetails.getUserName());

    }

}
