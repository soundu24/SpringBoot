package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
