package ru.graduation.repository;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("/spring-app.xml");



            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
//            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
//            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ROLE_ADMIN));
//            CrudUserRepository crudUserRepository = appCtx.getBean(CrudUserRepository.class);
//            System.out.println(crudUserRepository.toString() );

        }
    }

