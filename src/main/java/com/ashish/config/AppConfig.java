package com.ashish.config;

import com.ashish.Alien;
import com.ashish.Computer;
import com.ashish.Desktop;
import com.ashish.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.ashish")
public class AppConfig {
//    Qualifier is used to specify which bean to use similar to ref in xml but if we not wanna use this we can use @Primary in the bean
   /* @Bean
    public Alien alien(@Qualifier("desktop") Computer computer) {
        Alien alien = new Alien();
        alien.setAge(10);
//        This is manual way of setting the object use autowiring instead
//        alien.setComputer(desktop());
        alien.setComputer(computer);
        return alien;
    }

    @Bean(name = "desktop")
    @Scope("prototype")
    public Desktop desktop() {
        return new Desktop();
    }

    @Bean(name = "laptop")
    @Primary
    public Laptop laptop() {
        return new Laptop();
    }*/
}
// stereotype annotations
// @Component : generic stereotype for any Spring-managed component or bean we can use this annotation for any class