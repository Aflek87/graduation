package ru.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.model.Menu;

import java.util.List;

public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional
    Menu save(Menu menu);

    @Transactional
    @Modifying
    @Query("DELETE FROM Menu u WHERE u.id=:id")
    int delete(@Param("id") int id);

    // null if Menu do not belong to userId
    Menu findById(int id);

    // ORDERED dateTime desc
    List<Menu> findAll();
}
