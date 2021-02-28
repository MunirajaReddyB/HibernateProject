package org.muniraja.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muniraja.dto.Address;
import org.muniraja.dto.UserDetails;
import org.muniraja.hibernate.util.HibernateUtil;

public class HibernateMain {


    public void saveUserdetails(SessionFactory sf){

        Session session = sf.openSession();
        try{
            Address address = new Address();
            address.setStreet("Gachibowli");
            address.setCity("Hyd");
            address.setState("Telangana");
            address.setPinCode("123456");

            UserDetails user = new UserDetails();
            user.setUserName("Vijay Devarakonda");
            user.setAddress(address);

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
            session.close();
        }

    }
    public void getUserDetails(SessionFactory sessionFactory){

        Session session = sessionFactory.openSession();
        try{

            UserDetails userDetails = null;
            //retrieving objects from db using hibernate get() method

            session.beginTransaction();
            userDetails = (UserDetails) session.get(UserDetails.class,1);
            System.out.println("UserId:"+userDetails.getUserId());
            System.out.println("UserName:"+userDetails.getUserName());
            System.out.println("Street Nmae:"+userDetails.getAddress().getStreet());
            System.out.println("City:"+userDetails.getAddress().getCity());
            System.out.println("State:"+userDetails.getAddress().getState());
            System.out.println("PinCode:"+userDetails.getAddress().getPinCode());
        }catch(Exception e){
            e.printStackTrace();
            session.close();
        }

    }
    public static void main(String[] args){

        SessionFactory sf = HibernateUtil.getSessionFactory();
        HibernateMain mainObj = new HibernateMain();
        mainObj.saveUserdetails(sf);
        mainObj.getUserDetails(sf);

    }

}
