package ru.graduation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.model.Menu;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudMenuRepository;

    @Transactional
    @Override
    public Menu save(Menu menu) {
        return crudMenuRepository.save(menu);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Menu get(int id) {
        return crudMenuRepository.findById(id);
    }

    @Override
    public List<Menu> getAll() {
        return crudMenuRepository.findAll();
    }
}
