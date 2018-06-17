package ru.graduation.repository;

//import java.time.LocalDateTime;

import ru.graduation.model.Menu;

import java.util.List;

public interface MenuRepository {
    // null if updated Menu do not belong to userId
    Menu save(Menu Menu, int restotanId);

    // false if Menu do not belong to userId
    boolean delete(int id);

    // null if Menu do not belong to userId
    Menu get(int id);

    // ORDERED dateTime desc
    List<Menu> getAll();

    // ORDERED dateTime desc
    //List<Menu> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

}
