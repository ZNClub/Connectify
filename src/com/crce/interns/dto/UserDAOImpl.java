package com.crce.interns.dto;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.stat.*;
public class UserDAOImpl implements IUserDAO {
    SessionFactory sessionFactory1 = new  Configuration().configure("mysqlconfig.cfg.xml").buildSessionFactory();//interface is used to access mysql database
    SessionFactory sessionFactory2 = new Configuration().configure("postgresconfig.cfg.xml").buildSessionFactory();//interface is used to access postgres database
    Session session = null;
    Transaction transaction = null;
    
    public void findUsers() {
        ArrayList<User> a = new ArrayList<User>();
               try {
            session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            Criteria crit = session.createCriteria(User.class);
            a = (ArrayList) crit.list();//retrieving the details from userdetails table in mysql database
            // System.out.println("Records from mysql Database");
            for (User user : a) {
                System.out.println( user.getUsername()+" "+user.getRole_id()+" "+user.getUser_password()+" "+user.getCurrent_state()+" ");
                
            }
            session.close();
            session = sessionFactory2.openSession();
            Criteria crit1 = session.createCriteria(User.class);
            a = (ArrayList) crit1.list();//retrieving the details from userdetails table in postgres database
            
            //System.out.println("Records from postgres Database");
            for (User user : a) {
                System.out.println( user.getUsername()+" "+user.getRole_id()+" "+user.getUser_password()+" "+user.getCurrent_state()+" ");;
            }
            session.close();
        } catch (Exception he) {
            he.printStackTrace();
        }
    }
    
    public void findQualification() {
        ArrayList<Qualification> a = new ArrayList<Qualification>();
               try {
            session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            Criteria crit = session.createCriteria(Qualification.class);
            a = (ArrayList) crit.list();
            // System.out.println("Records from mysql Database");
            for (Qualification qual : a) {
                System.out.println(qual.getUsername() + " " + qual.getNo_of_kts() + " " + qual.getPercentage()+" "+qual.getGpa()+" "+ qual.getMarks_obtained()+" "+qual.getTotal_marks()
                +" ");
                
            }
            session.close();
            
        } catch (Exception he) {
            he.printStackTrace();
        }
    }
    
    
    public void findUP(String role) {
        ArrayList<User> a = new ArrayList<User>();
               try {
            	   if(role.equals("1")){
            session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            Criteria crit = session.createCriteria(User.class);
            a = (ArrayList) crit.list();
             //System.out.println("Records from mysql Database");
            for (User user : a) {
            	//if(user.getRole_id().equals(role))
                System.out.println(user.getUsername() + " "  + user.getUser_password()+" ");
                
            }
            session.close();}
            	   else
            	   {
            session = sessionFactory2.openSession();
            Criteria crit1 = session.createCriteria(User.class);
            a = (ArrayList) crit1.list();
            //System.out.println("Records from postgres Database");
            for (User user : a) {
            	//if(user.getRole_id().equals(role))
            	System.out.println(user.getUsername() + " "  + user.getUser_password()+" ");
                 }
            session.close();}
        } catch (Exception he) {
            he.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
	public void insertUser(User e,Qualification q) {
        try {
        	if(e.getRole_id().equals("1"))
        	{
        	session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.save(e);//entering the database in mysql database
            session.save(q);
            transaction.commit();
            session.close();
        	}
        	else
        	{
            session = sessionFactory2.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.save(e); //Entering the data in postgres database
            transaction.commit();
            session.close();
            session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.save(q);// entering the database in mysql database
            transaction.commit();
            session.close();
        	
        	}
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}