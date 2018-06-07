package ru.graduation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.graduation.repository.UserRepository;
import ru.graduation.model.User;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(AdminRestController.REST_URL)
public class AdminRestController {

    @Autowired
    private UserRepository userRepository;

    static final String REST_URL = "/rest/admin/users";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return userRepository.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@RequestBody User user) {
        User created = userRepository.save(user);

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uriOfNewResource);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        userRepository.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") int id) {
        userRepository.save(user);
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByMail(@RequestParam("email") String email) {
        return userRepository.getByEmail(email);
    }
}