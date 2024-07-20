package org.ashish.java;

import org.ashish.model.ManyAnswer;
import org.ashish.model.ManyQuestion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AllManyMapping {

    public static void main(String[] args) {

        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Transaction transaction = null;
        boolean flag = false;
        //    Step 1:Create a Configuration instance
        configuration = new Configuration();
//        Step 2: Load configuration from hibernate.cfg.xml
        configuration.configure();
//        Step 3: Build a SessionFactory from the Configuration
        sessionFactory = configuration.buildSessionFactory();
//        Step 4: Open a session from the SessionFactory
       Session session = sessionFactory.openSession();
        ManyQuestion manyQuestion = new ManyQuestion();
        try {

            manyQuestion.setId(1);
            manyQuestion.setQuestion("What is your name?");

            ManyAnswer manyAnswer = new ManyAnswer();
            manyAnswer.setId(1);
            manyAnswer.setAnswer("My name is Rakhi");
            manyAnswer.setQuestions(manyQuestion);

            ManyAnswer manyAnswer1 = new ManyAnswer();
            manyAnswer1.setId(2);
            manyAnswer1.setAnswer("Randi of Ashish who satisfies all his needs");
            manyAnswer1.setQuestions(manyQuestion);

            List<ManyAnswer> manyAnswers = new ArrayList<ManyAnswer>();
            manyAnswers.add(manyAnswer);
            manyAnswers.add(manyAnswer1);

            manyQuestion.setAnswers(manyAnswers);

            transaction = session.beginTransaction();
            session.persist(manyQuestion);
            flag = true;
        }catch (HibernateException err) {
            err.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                if (flag) {
                    transaction.commit();
                } else {
                    transaction.rollback();
                }
            }
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }
}
