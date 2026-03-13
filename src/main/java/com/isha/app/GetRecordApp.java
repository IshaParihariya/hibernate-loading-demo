package com.isha.app;

import com.isha.model.StudentDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetRecordApp
{
    public static void main(String[] args)
    {
        /*
        Loading :
        Loading = fetching entity data from the database into a Java object

        get() immediately fetches the entity and returns null if not found,
         while load() or getReference() returns a proxy object and throws an exception
          when the entity is accessed but does not exist.

 1. Using get()
session.get()
     ↓
SQL executes immediately
     ↓
Full object returned


2. Using getReference() or load() => proxy object is created then the actual object i.e., 2 objects
session.getReference()
     ↓
Proxy object created
     ↓
Access property
     ↓
SQL executes

Note: getReference : preferred as used in new ones
also lazyy loading is better as Better performance
lazy vs eager :
Lazy loading fetches data only when it is accessed (load or getReference),
while eager loading fetches related data immediately when the entity is loaded(get).
         */
        SessionFactory sessionFactory=  new Configuration().configure().buildSessionFactory();
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try
        {
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            // older way (deprecated)
            //StudentDetail sd=session.load(StudentDetail.class,1);
            // new way (preferred)
            StudentDetail sd=session.getReference(StudentDetail.class,1);
            System.out.println("id: "+sd.getSid());
            // after clicking enter in the console it will continue
            //System.in.read(); //System.in.read() reads a single byte from the standard input stream and returns its ASCII value as an integer.
            System.out.println("name: "+sd.getSname());
            System.out.println("email :"+sd.getSemail());
            System.out.println("city :"+sd.getScity());
            flag=true;
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(flag==true) //it means done with the operation hence commit
            {
                transaction.commit();
            }
            else
            {
                // if not done with the operation then just rollback i.e., no changes at all
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }
    }
}
