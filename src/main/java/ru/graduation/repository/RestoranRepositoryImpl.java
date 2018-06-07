package ru.graduation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.graduation.model.Restoran;

import java.util.List;

@Repository
public class RestoranRepositoryImpl implements RestoranRepository {

    @Autowired
    CrudRestoranRepository crudRepository;

    @Override
    public Restoran save(Restoran restoran) {
        return crudRepository.save(restoran);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Restoran get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public Restoran getByName(String name) {
        return crudRepository.findByName(name);
    }

    @Override
    public List<Restoran> getAll() {
        return crudRepository.findAll();
    }
}
