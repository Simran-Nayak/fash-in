package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import edu.rims.Fash_in.constant.CategoryStatus;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter

public class Category extends Auditable {

    @Id
    @Column(name = "category_id", length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String categoryId;

    @Column(name = "category_title", nullable = false, length = 255)
    private String categoryTitle;

    @Column(name = "category_description", columnDefinition = "TEXT")
    private String categoryDescription;

    @Column(name = "category_price", nullable = false)
    private double categoryPrice;

    @Column(name = "category_image_url", nullable = false, columnDefinition = "TEXT")
    private String categoryImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_status", nullable = false, columnDefinition = "ENUM('ACTIVE', 'INACTIVE')")
    private CategoryStatus categoryStatus = CategoryStatus.ACTIVE;

    @OneToMany(mappedBy ="category")
    private List<Product> products;

    public Category getCategoryById(String categoryId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryById'");
    }

    public Object getAllCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }

    public Object createCategory(Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCategory'");
    }

}

