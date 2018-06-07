package ru.graduation.repository;

import org.springframework.data.repository.query.Param;
import ru.graduation.model.Voting;

import java.time.LocalDateTime;
import java.util.List;

public interface VotingRepository {

    Voting save(Voting voting);

    // false if not found
    boolean delete(int id);

    // null if not found
    Voting get(int id);

    List<Voting> getAll();

    List<Voting> getBetweenDateByUser(LocalDateTime startDate,LocalDateTime endDate,int userId);
}
