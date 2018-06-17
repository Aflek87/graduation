package ru.graduation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.model.Menu;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudRepository;
    @Autowired
    private CrudRestoranRepository crudRestoranRepository;

    @Transactional
    @Override
    public Menu save(Menu menu, int restotanId) {
        if (!menu.isNew() && get(menu.getId()) == null) {
            return null;
        }
        menu.setRestoran(crudRestoranRepository.getOne(restotanId));
        return crudRepository.save(menu);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Menu get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> getAll() {
        return crudRepository.findAll();
    }
}
