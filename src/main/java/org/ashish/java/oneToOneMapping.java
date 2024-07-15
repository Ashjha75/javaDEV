package org.ashish.java;

import org.ashish.model.Question;
import org.ashish.model.Answers;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class oneToOneMapping {
    public static void main(String[] args) {

        Configuration configuration=null;
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

//        Step 1: Create a Configuration instance
        configuration=new Configuration();
//        Step 2: Load configuration from hibernate.cfg.xml
        configuration.configure();
//        Step 3: Build a SessionFactory from the Configuration
        SessionFactory sessionFactory=configuration.buildSessionFactory();
//        Step 4: Open a session from the SessionFactory
        session=sessionFactory.openSession();
//        Step 5: Create a new Question instance
        Question question = new Question();
        question.setQuestionText("What is Java?");
//        step 6: Create a new Answer instance
        Answers answer = new Answers();
        answer.setAnswerText("Java is a programming language");
//        begin the transaction
        try{
            transaction=session.beginTransaction();
//
//            Set both side of relation
            question.setAnswer(answer);
            answer.setQuestion(question);

            session.persist(question);
            session.persist(answer);
//           Question ques= session.get(Question.class,1);
//            System.out.println(ques);
            flag=true;
        }
        catch (HibernateException err){
            err.printStackTrace();}
        catch (Exception err){
            err.printStackTrace();
        }
        finally {
            if(flag) transaction.commit();
            else{
               if(transaction!=null){
                    transaction.rollback();
                }
            }
            session.close();
            sessionFactory.close();
        }

    }
}
