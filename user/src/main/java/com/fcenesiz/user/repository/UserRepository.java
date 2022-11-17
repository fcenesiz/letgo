package com.fcenesiz.user.repository;

import com.fcenesiz.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
