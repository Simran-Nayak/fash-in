package edu.rims.Fash_in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.Fash_in.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    
} 