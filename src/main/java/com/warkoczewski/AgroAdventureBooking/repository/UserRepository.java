package com.warkoczewski.AgroAdventureBooking.repository;

import com.warkoczewski.AgroAdventureBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User getUserByEmail(String email);
    User getUserByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
