package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> create(User newUser) {
        return userRepository.save(newUser);
    }

    public Mono<User> update(Long id, User editedUser) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    user.setId(id);
                    user.setFirstName(editedUser.getFirstName());
                    user.setLastName(editedUser.getLastName());
                    user.setEmail(editedUser.getEmail());
                    return userRepository.save(user);
                });
    }

    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id);
    }
    // END
}
