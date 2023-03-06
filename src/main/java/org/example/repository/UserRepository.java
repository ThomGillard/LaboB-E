package org.example.repository;

import org.example.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u where u.login = ?1")
    Optional<User> findByLogin(String login);

}
