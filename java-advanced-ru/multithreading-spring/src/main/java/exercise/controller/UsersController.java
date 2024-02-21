package exercise.controller;

import exercise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import exercise.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    // BEGIN
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> addUser(@RequestBody User newUser) {
        return userService.create(newUser);
    }

    @PatchMapping("/{id}")
    public Mono<User> updateUser(@PathVariable Long id,
                                 @RequestBody User editedUser) {
        return userService.update(id, editedUser);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser (@PathVariable Long id) {
        return userService.delete(id);
    }
    // END
}
