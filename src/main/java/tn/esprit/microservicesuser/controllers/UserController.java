package tn.esprit.microservicesuser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.microservicesuser.entities.UserEntity;
import tn.esprit.microservicesuser.services.UserServiceImpl;

import java.util.List;

/**
 * This class represents the REST controller for managing user resources.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * The service implementation for user management.
     */
    @Autowired
    private UserServiceImpl userService;

    /**
     * Returns a list of all users.
     *
     * @return A list of all users.
     */
    @GetMapping("/list")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Returns the user with the specified ID.
     *
     * @param id The ID of the user to return.
     * @return The user with the specified ID, or null if no such user exists.
     */
    @GetMapping("/list/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Returns the user with the specified code.
     *
     * @param code The code of the user to return.
     * @return The user with the specified code, or null if no such user exists.
     */
    @GetMapping("/list/codes/{code}")
    public UserEntity getUserByCode(@PathVariable String code) {
        return userService.getUserByCode(code);
    }

    /**
     * Creates a new user.
     *
     * @param userEntity The user to create.
     * @return The newly created user.
     */
    @PostMapping("/list/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    /**
     * Updates the user with the specified ID.
     *
     * @param id         The ID of the user to update.
     * @param userEntity The new user data.
     * @return The updated user, or null if no such user exists.
     */
    @PutMapping("/list/update/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userService.updateUser(id, userEntity);
    }
    /**
     * Updates the user with the specified code.
     *
     * @param code         The code of the user to update.
     * @param userEntity The new user data.
     * @return The updated user, or null if no such user exists.
     */
    @PutMapping("/list/update/codes/{code}")
    public UserEntity updateUserByCode(@PathVariable String code, @RequestBody UserEntity userEntity) {
        return userService.updateUserByCode(code, userEntity);
    }

    /**
     * Deletes the user with the specified ID.
     *
     * @param id The ID of the user to delete.
     */
    @DeleteMapping("/list/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    /**
     * Deletes the user with the specified code.
     *
     * @param code The code of the user to delete.
     */
    @DeleteMapping("/list/delete/codes/{code}")
    public void deleteUserByCode(@PathVariable String code) {
        userService.deleteUserByCode(code);
    }

    /**
     * Deletes All users
     *
     */
    @DeleteMapping("/list/delete")
    public void deleteAll() {
        for (UserEntity user : userService.getAllUsers()) {
                userService.deleteUser(user.getId());
        }
    }
}
