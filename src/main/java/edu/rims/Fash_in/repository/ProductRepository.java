package edu.rims.Fash_in.repository;

import edu.rims.Fash_in.entity.Product;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
    // List<Product> FindByProductNameContainingIgnoreCase(String productName);
}
