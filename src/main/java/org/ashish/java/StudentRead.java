package org.ashish.java;

import org.ashish.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentRead {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = null;
//        boolean flag=false;

        try {
            session = sessionFactory.openSession();
            Student student = session.get(Student.class, 4);
            //get() method will hit the database and fetch the student object

//            --------lazy-loading-----------
            //get() method will hit the database and fetch the student object
            //getReference() and load() method will not hit the database and return a proxy object
            //when we call any method on the proxy object then only it will hit the database
            //this is called lazy-loading
//            load is same as getReference
//            Student student = session.load(Student.class, 4);
//            Student student = session.getReference(Student.class, 4);
//            System.out.println(student);

//            Note: If the student with ID 4 does not exist in the database, the get() method will return null.
//            If the student with ID 4 does not exist in the database, the load() and getReference() method will throw an ObjectNotFoundException.
        } catch (HibernateException err) {
            err.printStackTrace();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
