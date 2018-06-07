package ru.graduation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.graduation.AuthorizedUser;
import ru.graduation.model.User;

import java.util.List;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository, UserDetailsService {

    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "name", "email");

    @Autowired
    private CrudUserRepository crudRepository;

    @Override
    public User save(User user) {
        System.out.println("!save");
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return crudRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = crudRepository.findByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
