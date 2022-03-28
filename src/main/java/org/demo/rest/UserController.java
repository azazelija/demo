package org.demo.rest;

import org.demo.dto.User;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/role/user")
    public ResponseEntity<Set<User>> getByRoleUser() {
        Set<User> users = userService.getByRoleUser();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/role/admin")
    public ResponseEntity<Set<User>> getByRoleAdmin() {
        Set<User> users = userService.getByRoleAdmin();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedMessage = userService.update(user);

        return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
