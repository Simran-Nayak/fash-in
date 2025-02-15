package edu.rims.Fash_in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.Fash_in.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
    
}
