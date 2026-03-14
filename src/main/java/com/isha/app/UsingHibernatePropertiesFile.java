package com.isha.app;

import com.isha.model.StudentDetailForWithoutXML;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UsingHibernatePropertiesFile
{
    public static void main(String[] args)
{
    Configuration config = new Configuration();
    config.addAnnotatedClass(StudentDetailForWithoutXML.class);

    SessionFactory sessionFactory = config.buildSessionFactory();
    Session session=sessionFactory.openSession();
    Transaction transaction=session.beginTransaction();
    StudentDetailForWithoutXML sd=new StudentDetailForWithoutXML();
    sd.setSid(3);
    sd.setSname("missie");
    sd.setSemail("abccc@gmail.com");
    sd.setScity("Mysuru");
    System.out.println(sd);
    // saving
    session.persist(sd);

    transaction.commit();


    session.close();
    sessionFactory.close();

}
}
