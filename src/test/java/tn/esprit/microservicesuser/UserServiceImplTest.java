package tn.esprit.microservicesuser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.microservicesuser.entities.UserEntity;
import tn.esprit.microservicesuser.repositories.UserRepository;
import tn.esprit.microservicesuser.services.UserServiceImpl;

/**
 * Test class for the UserServiceImpl class. Uses Mockito and JUnit5 to perform unit tests.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    /**
     * Tests the getAllUsers() method of the UserServiceImpl class.
     * Verifies that the method returns a list of UserEntity objects with the correct properties.
     */
    @Test
    public void testGetAllUsers() {
        // Test setup
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1L, "Ahmed", "Bahri", "ahmed.bahri.g@gmail.com", "password"));
        users.add(new UserEntity(2L, "Bahri", "Ahmed", "bahri.ahmed@esprit.tn", "password"));
        when(userRepository.findAll()).thenReturn(users);

        // Test execution
        List<UserEntity> result = userServiceImpl.getAllUsers();

        // Test assertions
        assertEquals(users.size(), result.size());
        assertEquals(users.get(0).getFirstName(), result.get(0).getFirstName());
        assertEquals(users.get(0).getLastName(), result.get(0).getLastName());
        assertEquals(users.get(0).getEmail(), result.get(0).getEmail());
        assertEquals(users.get(0).getPassword(), result.get(0).getPassword());
        assertEquals(users.get(1).getFirstName(), result.get(1).getFirstName());
        assertEquals(users.get(1).getLastName(), result.get(1).getLastName());
        assertEquals(users.get(1).getEmail(), result.get(1).getEmail());
        assertEquals(users.get(1).getPassword(), result.get(1).getPassword());
    }

    /**
     * Tests the getUserById() method of the UserServiceImpl class.
     * Verifies that the method returns a UserEntity object with the correct properties.
     */
    @Test
    public void testGetUserById() {
        // Test setup
        UserEntity user = new UserEntity(1L, "Ahmed", "Bahri", "ahmed.bahri.g@gmail.com", "password");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Test execution
        UserEntity result = userServiceImpl.getUserById(1L);

        // Test assertions
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getPassword(), result.getPassword());
    }

    /**
     * Tests the createUser() method of the UserServiceImpl class.
     * Verifies that the method returns a UserEntity object with the correct properties.
     */
    @Test
    public void testCreateUser() {
        // Test setup
        UserEntity user = new UserEntity(null, "Ahmed", "Bahri", "ahmed.bahri.g@gmail.com", "password");
        when(userRepository.save(user)).thenReturn(new UserEntity(1L, "Ahmed", "Bahri", "ahmed.bahri.g@gmail.com", "hashedPassword"));

        // Test execution
        UserEntity result = userServiceImpl.createUser(user);

        // Test assertions
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals("hashedPassword", result.getPassword());
    }

    /**
     * Tests the updateUser() method of the UserServiceImpl class.
     * Verifies that the method returns a UserEntity object with the correct properties.
     */
    @Test
    public void testUpdateUser() {
        // Test setup
        UserEntity existingUser = new UserEntity(1L, "Ahmed", "Bahri", "ahmed.bahri.g@gmail.com", "password");
        UserEntity updatedUser = new UserEntity(null, "Bahri", "Ahmed", "ahmed.bahri@iliadeconsulting.com", "newPassword");
        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(new UserEntity(1L, "Bahri", "Ahmed", "ahmed.bahri@iliadeconsulting.com", "hashedNewPassword"));

        // Test execution
        UserEntity result = userServiceImpl.updateUser(1L, updatedUser);

        // Test assertions
        assertEquals(updatedUser.getFirstName(), result.getFirstName());
        assertEquals(updatedUser.getLastName(), result.getLastName());
        assertEquals(updatedUser.getEmail(), result.getEmail());
        assertEquals("hashedNewPassword", result.getPassword());
    }

    /**
     * Test case to verify that a user is deleted from the database correctly.
     * It calls the deleteUser method of UserServiceImpl and verifies that the deleteById method of UserRepository is called with the correct parameter.
     */
    @Test
    public void testDeleteUser() {
        // Test execution
        userServiceImpl.deleteUser(1L);

        // Verify that the deleteById method of userRepository was called with the correct parameter
        verify(userRepository, times(1)).deleteById(1L);
    }
}

