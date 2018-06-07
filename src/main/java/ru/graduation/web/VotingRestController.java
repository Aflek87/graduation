package ru.graduation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.graduation.model.Voting;
import ru.graduation.repository.VotingRepository;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(VotingRestController.REST_URL)
public class VotingRestController {
    static final String REST_URL = "/rest/voting";

    @Autowired
    private VotingRepository votingRepository;

    @GetMapping("/{id}")
    public Voting get(@PathVariable("id") int id) {
        return votingRepository.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        votingRepository.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Voting> getAll() {
        return votingRepository.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Voting voting, @PathVariable("id") int id) {
        votingRepository.save(voting);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Voting> create(@RequestBody Voting voting) {
        Voting created = votingRepository.save(voting);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/filter")
    public List<Voting> getBetweenDateByUser(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "userId", required = false) int userId){
            return votingRepository.getBetweenDateByUser( startDate, endDate, userId);
}

}
