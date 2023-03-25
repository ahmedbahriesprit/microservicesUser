package tn.esprit.microservicesuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservicesuser.entities.UserEntity;
import tn.esprit.microservicesuser.repositories.UserRepository;

import java.util.List;

/**
 * Implementation of the IUserService interface that provides CRUD operations for user entities.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@Service
public class UserServiceImpl implements IUserService {
    /**
     * The UserRepository object used for accessing user data in the database.
     * This object is automatically initialized and injected into the UserController
     * by Spring's dependency injection framework using the @Autowired annotation.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a list of all users in the database.
     *
     * @return A list of user entities.
     */
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user entity from the database based on its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user entity with the specified ID, or null if no such user exists.
     */
    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new user entity in the database.
     *
     * @param userEntity The user entity to create.
     * @return The created user entity, with a hashed password.
     */
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(UserEntity.hashPassword(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    /**
     * Updates an existing user entity in the database.
     *
     * @param id         The ID of the user to update.
     * @param userEntity The updated user entity.
     * @return The updated user entity, with a hashed password.
     */
    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        UserEntity existingUserEntity = userRepository.findById(id).orElse(null);
        if (existingUserEntity != null) {
            existingUserEntity.setFirstName(userEntity.getFirstName());
            existingUserEntity.setLastName(userEntity.getLastName());
            existingUserEntity.setEmail(userEntity.getEmail());
            existingUserEntity.setPassword(UserEntity.hashPassword(userEntity.getPassword()));
            return userRepository.save(existingUserEntity);
        }
        return null;
    }

    /**
     * Deletes a user entity from the database based on its ID.
     *
     * @param id The ID of the user to delete.
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
