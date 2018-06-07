package ru.graduation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.graduation.model.Voting;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class VotingRepositoryImpl implements VotingRepository {

    @Autowired
    private CrudVotingRepository repository;

    @Override
    public Voting save(Voting voting) {
        if (!voting.isNew() && get(voting.getId()) == null) {
            return null;
        } else if (!voting.isNew() && !LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(11, 0, 0))) {
            return null;
        } else if (voting.isNew()
                && getBetweenDateByUser(voting.getOperDate(), voting.getOperDate(), voting.getUser().getId()).size() > 0 ){
            return null;
        }

        return repository.save(voting);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Voting get(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Voting> getAll() {
        return repository.findAll();
    }

    public List<Voting> getBetweenDateByUser(LocalDateTime startDate,LocalDateTime endDate,int userId)
    {
        return repository.getBetweenDateByUser( startDate, endDate, userId);
    }
}
