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
