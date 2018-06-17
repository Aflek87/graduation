package ru.graduation.repository;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graduation.model.Menu;
import ru.graduation.model.Role;
import ru.graduation.model.User;
import ru.graduation.web.AdminRestController;
import ru.graduation.web.MenuRestController;

import java.util.Arrays;


public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("/spring-app.xml", "/spring-mvc.xml");
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
//            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
//            adminUserController.createWithLocation(new User(null, "userName", "email@mail.ru", "password", Role.ROLE_ADMIN));
//            CrudUserRepository crudUserRepository = appCtx.getBean(CrudUserRepository.class);
//            System.out.println(crudUserRepository.toString() );
        MenuRestController menuRest = appCtx.getBean(MenuRestController.class);
        Menu menu100005 = menuRest.get(100005);
        System.out.println(menu100005);




        }
    }

