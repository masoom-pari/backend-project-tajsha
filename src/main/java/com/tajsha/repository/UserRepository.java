
package com.tajsha.repository;

import com.tajsha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Login ke liye: Email se user ko find karna
    User findByEmail(String email);
}