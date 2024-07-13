package org.ashish.java;

import org.ashish.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//
public class StudentHibernate {

    public static void main(String[] args) {
        // Initialize variables for configuration, session factory, session, and transaction
        Configuration configuration = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false; // Flag to track if the transaction should be committed

        // Step 1: Create a Configuration instance
        configuration = new Configuration();
        // Step 2: Load configuration from hibernate.cfg.xml
        configuration.configure();

        // Step 3: Build a SessionFactory from the Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Step 4: Open a session from the SessionFactory
        session = sessionFactory.openSession();

        // Step 5: Create a new Student instance
        Student student = new Student();
        student.setStudentId(7);
        student.setStudentName("Rakhi_Ke_gol_gol_gal");
        student.setStudentAddress("Saheed Nagar");
        student.setStudentEmail("rakhi@Ke_gol_gol_gal.com");

        try {
            // Step 6: Begin a transaction
            transaction = session.beginTransaction();
            // Step 7: Persist the student object
            session.persist(student);
            flag = true; // Indicate success to commit the transaction later
        } catch (HibernateException err) {
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
