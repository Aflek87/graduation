package ru.graduation.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RestoranRepositoryImplTest {

    @Autowired
    private CrudRestoranRepository crudRestoranRepository;

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getByName() throws Exception {
        crudRestoranRepository.findByName("Пушкин");
    }

    @Test
    public void getAll() throws Exception {
        crudRestoranRepository.findAll();
    }
}