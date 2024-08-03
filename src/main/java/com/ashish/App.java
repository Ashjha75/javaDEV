package com.ashish;

import com.ashish.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
  /*  public static void main( String[] args )
    {
//        1st: Normal way of creating object

//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = (Alien) context.getBean("alien");
//        obj.code();

//        2nd: Setting scope (singleton/prototype) in spring.xml
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj1 = (Alien) context.getBean("alien");
//        obj1.code(10);
//
//        Alien obj2 = (Alien) context.getBean("alien");
//        obj2.code(20);

//        3rd: seter injection
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Laptop lap = (Laptop) context.getBean("lap");
//        Alien obj = (Alien) context.getBean("alien");
//        System.out.println(obj.getAge());
//        System.out.println(obj.getLaptop());

//        4th: constructor injection
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = (Alien) context.getBean("alien");
//        obj.code();

//        5th:getting bean by type
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = context.getBean(Alien.class);
//        obj.code();
    }*/

    //    Java based cofiguration
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Alien obj = context.getBean(Alien.class);
        obj.code();
        System.out.println(obj.getAge());
    }
}
