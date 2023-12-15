package org.beatrice.bookrenting.controller;

import org.beatrice.bookrenting.dto.User;
import org.beatrice.bookrenting.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getRegisteredUsers();
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public String deleteUserById (@PathVariable ("id") String id) {
        userService.deleteUserById (id);
        return ("User " + id + " was deleted");
    }



}
