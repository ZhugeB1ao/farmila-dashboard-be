package com.codewithzhugeb1ao.familarbackend.repository;

import com.codewithzhugeb1ao.familarbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
