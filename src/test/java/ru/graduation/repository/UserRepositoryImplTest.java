package ru.graduation.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduation.model.Role;
import ru.graduation.model.User;

import java.util.Collections;
import java.util.Date;

@ContextConfiguration("classpath:/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryImplTest {

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Test
    public void save() throws Exception {
        //System.out.println("test!!"+crudUserRepository.toString());
        User newUser = new User(null, "New23", "new@gmail22.com", "newPass23", false, new Date(), Collections.singleton(Role.ROLE_USER));
        //System.out.println("test!!!"+newUser.toString());
        crudUserRepository.save(newUser);
    }

    @Test
    public void get() throws Exception {
        crudUserRepository.findById(100023);
    }

    @Test
    public void delete() throws Exception {
        crudUserRepository.delete(100021);
    }

    @Test
    public void getByEmail() throws Exception {
        crudUserRepository.findByEmail("new@gmail23.com");
    }

    @Test
    public void getAll() throws Exception {
        crudUserRepository.findAll();
    }
}