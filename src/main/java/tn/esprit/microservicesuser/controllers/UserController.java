package tn.esprit.microservicesuser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservicesuser.entities.UserEntity;
import tn.esprit.microservicesuser.services.IUserService;

import java.util.List;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return A list of user entities.
     */
    @GetMapping("")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Retrieves a user entity based on its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user entity with the specified ID, or a 404 Not Found response if no such user exists.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        UserEntity user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    /**
     * Creates a new user entity.
     *
     * @param userEntity The user entity to create.
     * @return The created user entity, with a hashed password.
     */
    @PostMapping("")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity createdUser = userService.createUser(userEntity);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * Updates an existing user entity.
     *
     * @param id         The ID of the user to update.
     * @param userEntity The updated user entity.
     * @return The updated user entity, with a hashed password, or a 404 Not Found response if no such user exists.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable("id") Long id, @RequestBody UserEntity userEntity) {
        UserEntity updatedUser = userService.updateUser(id, userEntity);
        if (updatedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
    }

    /**
     * Deletes a user entity based on its ID.
     *
     * @param id The ID of the user to delete.
     * @return A 204 No Content response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Authenticates a user by their code and password.
     *
     * @param code     The user's code.
     * @param password The user's password.
     * @return The authenticated user entity, or a 401 Unauthorized response if authentication fails.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<UserEntity> authenticate(@RequestParam("code") String code, @RequestParam("password") String password) {
        UserEntity user = userService.authenticate(code, password);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

}
