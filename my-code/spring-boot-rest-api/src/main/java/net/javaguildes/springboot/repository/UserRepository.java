package net.javaguildes.springboot.repository;

import net.javaguildes.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}