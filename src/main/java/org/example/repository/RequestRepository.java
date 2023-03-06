package org.example.repository;

import org.example.models.entity.Request;
import org.example.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request,Long> {
    Optional<Request> findByUser(User user);
}
