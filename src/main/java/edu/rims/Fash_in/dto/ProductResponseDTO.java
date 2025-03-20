package edu.rims.Fash_in.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductResponseDTO{
    private String productId;
    private String productTitle;
    private String productDescprition;
    private double productPrice;
    private int productStockQuantity;
    private String productStatus;
    private String ProductImageUrl;
    private CategoryResponse category;
    @Setter
    @Getter
    public class CategoryResponse{
        private String categoryId;
        private String categoryTitle;
    }
}