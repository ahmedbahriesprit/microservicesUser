package tn.esprit.microservicesuser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microservicesuser.entities.UserEntity;

import java.util.Optional;

/**
 * This interface represents the repository for managing UserEntity objects.
 * It extends the JpaRepository interface which provides basic CRUD operations
 * for the UserEntity class and allows us to easily perform database operations.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByCodeAndPassword(String code, String password);

}
