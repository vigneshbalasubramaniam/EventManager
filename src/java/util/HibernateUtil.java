/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author vi391762
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static
    {   try{
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    catch(Throwable e)
    {
        System.err.println("cant create sessionfactory"+e);
        throw new ExceptionInInitializerError();
    }
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    public static Session getCurrentSession( ) 
    {
        return sessionFactory.getCurrentSession();
    }
    public static Session openSession()
    {
        return sessionFactory.openSession();
    }
}
