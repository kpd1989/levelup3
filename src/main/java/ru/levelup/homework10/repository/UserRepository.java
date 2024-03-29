package ru.levelup.homework10.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.homework10.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(value = "User.role")
    Optional<User> findByLogin(String login);
}
