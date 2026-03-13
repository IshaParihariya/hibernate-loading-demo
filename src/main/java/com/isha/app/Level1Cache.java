package com.isha.app;

import com.isha.model.StudentDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Level1Cache
{
    public static void main(String[] args)
    {
        /*
        // ---------------------- CACHE ----------------------
// Cache is a temporary memory storage used to store frequently accessed data.
// It improves performance because data can be retrieved from memory instead of
// executing a database query every time.

// ------------------ FIRST LEVEL CACHE ------------------
// First Level Cache is the session-level cache provided by Hibernate by default.
// Every Hibernate Session has its own cache.

// How it works:
// When an entity is fetched from the database using session.get(),
// Hibernate stores that object inside the session cache.

// If the same entity is requested again within the same session,
// Hibernate returns the object from the cache instead of hitting the database.

// This reduces database queries and improves performance.

// Example Flow:
// 1st get() call → Hibernate checks session cache → Not found → Query runs → Object stored in cache
// 2nd get() call → Hibernate checks session cache → Object found → Returned from cache → No SQL query

// Proof in console output:
// The SQL query appears only once, even though the entity is printed multiple times.
         */
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session1=null; // session1 have level cache by default
        Session session2=null;// session2 has another level cache by default
        Transaction transaction=null;
        boolean flag=false;

        try
        {
            // session1
            session1=sessionFactory.openSession();
            transaction=session1.beginTransaction();
            StudentDetail sd=session1.get(StudentDetail.class,1);
            System.out.println(sd);
            StudentDetail sd1=session1.get(StudentDetail.class,1);
            System.out.println(sd1);
            StudentDetail sd2=session1.get(StudentDetail.class,1);
            System.out.println(sd2);
            // session2
            // the query again is there and all that again for this
            session2=sessionFactory.openSession();
            transaction=session2.beginTransaction();
            StudentDetail sd3=session2.get(StudentDetail.class,1); // asking for the same data but here session diff so that cache is not for this one
            System.out.println(sd3);
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
            session1.close();
            session2.close();
            sessionFactory.close();
        }
    }
}
