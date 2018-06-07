package ru.graduation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.graduation.model.Restoran;
import ru.graduation.repository.RestoranRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestoranRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestoranRestController {

    @Autowired
    private RestoranRepository repository;

    static final String REST_URL = "/rest/admin/restoran";

    @GetMapping
    public List<Restoran> getAll() {
        return repository.getAll();
    }

    @GetMapping(value = "/{id}")
    public Restoran get(@PathVariable("id") int id) {
        return repository.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoran> create(@RequestBody Restoran restoran) {
        Restoran created = repository.save(restoran);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Restoran restoran, @PathVariable("id") int id) {
        repository.save(restoran);
    }

    @GetMapping(value = "/by")
    public Restoran getByName(@RequestParam("name") String email) {
        return repository.getByName(email);
    }
}

