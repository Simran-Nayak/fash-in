package edu.rims.Fash_in.repository;

import edu.rims.Fash_in.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
    
}
