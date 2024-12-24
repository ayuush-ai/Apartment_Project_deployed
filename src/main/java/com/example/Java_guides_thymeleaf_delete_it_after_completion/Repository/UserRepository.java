package com.example.Java_guides_thymeleaf_delete_it_after_completion.Repository;

import com.example.Java_guides_thymeleaf_delete_it_after_completion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom queries can be added here, if needed
}
