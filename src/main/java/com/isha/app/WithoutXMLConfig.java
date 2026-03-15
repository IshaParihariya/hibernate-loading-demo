package com.isha.app;

import com.isha.model.StudentDetailForWithoutXML;
import jakarta.persistence.GeneratedValue;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WithoutXMLConfig
{
    /*
    Why must Hibernate entities have a no-argument constructor?
Because Hibernate uses reflection to instantiate entity objects, which requires a default constructor.
either public or protected default constructor.
     */
    public static void main(String[] args)
    {
       // NOTE :  @GeneratedValue used
        //the table in the db should have auto increment
        Configuration config=new Configuration();
        // spaces in between the configuration breaks the config.
        config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hibernetapp");
        config.setProperty("hibernate.connection.username","root");
        config.setProperty("hibernate.connection.password","Lovealarm@123");
        config.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.show_sql","true");
        config.setProperty("hibernate.format_sql","true");
        config.setProperty("hibernate.hbm2ddl.auto","update");

        //entity mapping
        config.addAnnotatedClass(StudentDetailForWithoutXML.class);

        SessionFactory sessionFactory= config.buildSessionFactory();

           Session session=sessionFactory.openSession();
           Transaction transaction=session.beginTransaction();
            StudentDetailForWithoutXML sd=new StudentDetailForWithoutXML();
           // sd.setSid(1); : @GeneratedValue annotation used
            sd.setSname("Jennie");
            sd.setSemail("xyz@gmail.com");
            sd.setScity("Seoul");
            System.out.println(sd);
            // saving
            session.persist(sd);

        transaction.commit();


        session.close();
            sessionFactory.close();

    }
}

