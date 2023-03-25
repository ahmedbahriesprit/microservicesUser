package tn.esprit.microservicesuser.services;

import tn.esprit.microservicesuser.entities.UserEntity;

import java.util.List;

/**
 * Interface for the User Service, which provides operations for managing user data.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
public interface IUserService {
    /**
     * Retrieve a list of all users in the system.
     *
     * @return A List of UserEntity objects representing all users in the system.
     */
    List<UserEntity> getAllUsers();

    /**
     * Retrieve a user with the specified ID.
     *
     * @param id The ID of the user to retrieve.
     * @return A UserEntity object representing the user with the specified ID, or null if not found.
     */
    UserEntity getUserById(Long id);

    /**
     * Create a new user with the specified data.
     *
     * @param userEntity A UserEntity object containing the data for the new user.
     * @return A UserEntity object representing the newly created user.
     */
    UserEntity createUser(UserEntity userEntity);

    /**
     * Update an existing user with the specified data.
     *
     * @param id         The ID of the user to update.
     * @param userEntity A UserEntity object containing the updated data for the user.
     * @return A UserEntity object representing the updated user, or null if the user was not found.
     */
    UserEntity updateUser(Long id, UserEntity userEntity);

    /**
     * Delete a user with the specified ID.
     *
     * @param id The ID of the user to delete.
     */
    void deleteUser(Long id);
}
