package org.ashish.java;

import org.ashish.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentUpdateDelete {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();

            Student student = new Student();
            student.setStudentId(4);
            student.setStudentName("Rakhi_ke_chote_si_kali_choot");
            student.setStudentAddress("Saheed Nagar ki randi");
            student.setStudentEmail("rakhi@ke_chote_si_kali_choot.com");

//            update
            session.merge(student);

//            delete
//            session.remove(student);
            flag=true;
        }
        catch (HibernateException err) {
            err.printStackTrace();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            // Step 8: Commit the transaction if flag is true, otherwise rollback
            if (flag) transaction.commit();
            else {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            // Step 9: Close the session and SessionFactory
            session.close();
//            sessionFactory.close();
        }

    }
}
