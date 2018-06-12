package ru.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.graduation.model.Voting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVotingRepository extends JpaRepository<Voting, Integer>{
    @Override
    @Transactional
    Voting save(Voting voting);

    @Transactional
    @Modifying
    @Query("DELETE FROM Voting u WHERE u.id=:id")
    int delete(@Param("id") int id);

    // null if not found
    Voting findById(int id);

    List<Voting> findAll();

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT v from Voting v WHERE v.user.id=:userId AND v.operDate BETWEEN :startDate AND :endDate ORDER BY v.operDate DESC")
    List<Voting> getBetweenDateByUser(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);


}
