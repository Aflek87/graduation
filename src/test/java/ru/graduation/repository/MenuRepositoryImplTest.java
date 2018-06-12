package ru.graduation.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.graduation.model.Menu;
import ru.graduation.model.Restoran;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuRepositoryImplTest {

    @Autowired
    private CrudMenuRepository crudMenuRepository;
    @Autowired
    private CrudRestoranRepository crudRestoranRepository;

    @Test
    public void save() throws Exception {
        Restoran restoran = new Restoran(null, "Локомотив", "На образцова");
        crudRestoranRepository.save(restoran);
        Map<String, String> delishes = new HashMap();
        delishes.put("Мясо по французски", "100");
        Menu menu = new Menu(null, LocalDate.of(2018, Month.MAY, 30), delishes);
        crudMenuRepository.save(menu);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {
        crudMenuRepository.findById(100005);
    }

    @Test
    public void getAll() throws Exception {
        crudMenuRepository.findAll();
    }
}