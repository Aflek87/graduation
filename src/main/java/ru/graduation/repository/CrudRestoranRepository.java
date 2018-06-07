package ru.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.model.Restoran;

public interface CrudRestoranRepository extends JpaRepository<Restoran, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restoran r WHERE r.id=:id")
    int delete(@Param("id") int id);

    Restoran save(Restoran restoran);

    Restoran findByName(String name);
}
