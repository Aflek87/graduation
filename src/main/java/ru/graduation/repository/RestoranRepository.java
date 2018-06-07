package ru.graduation.repository;

import ru.graduation.model.Restoran;

import java.util.List;

public interface RestoranRepository {
    Restoran save(Restoran restoran);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restoran get(int id);

    // null if not found
    Restoran getByName(String name);

    List<Restoran> getAll();
}
