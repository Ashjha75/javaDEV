package org.ashish.java;

import org.ashish.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * Demonstrates updating and deleting a Student entity using Hibernate.
 * This class includes the process of initializing a session factory, opening a session,
 * beginning a transaction, and performing update or delete operations on a Student entity.
 * Finally, it commits the transaction and closes the session and session factory.
 */
public class StudentUpdateDelete {

    public static void main(String[] args) {
        // Initialize the session factory with configuration and annotated classes
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            // Open a session from the session factory
            session = sessionFactory.openSession();
            // Begin a transaction
            transaction = session.beginTransaction();

            // Create a new Student instance for update
            Student student = new Student();
            student.setStudentId(4); // Set the ID of the student to update
            student.setStudentName("New Name"); // Set new values for the student
            student.setStudentAddress("New Address");
            student.setStudentEmail("newemail@example.com");

            // Update the student in the database
            session.merge(student);

            // Uncomment the following line to delete the student instead
            // session.remove(student);

            flag = true; // Indicate success to commit the transaction
        } catch (HibernateException err) {
            err.printStackTrace(); // Handle Hibernate exceptions
        } catch (Exception err) {
            err.printStackTrace(); // Handle other exceptions
        } finally {
            // Commit the transaction if flag is true, otherwise rollback
            if (flag) transaction.commit();
            else {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            // Close the session
            session.close();
            // Uncomment the following line to close the session factory
            // sessionFactory.close();
        }
    }
}