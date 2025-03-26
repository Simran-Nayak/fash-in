package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import edu.rims.Fash_in.constant.ProductStatus;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends Auditable {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "product_title", nullable = false, length = 255)
    private String productTitle;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private double productPrice;

    @Column(name = "product_stock_quantity", nullable = false)
    private int productStockQuantity;

    @Column(name = "product_image_url", columnDefinition = "TEXT")
    private String productImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", nullable = false, columnDefinition = "ENUM('ACTIVE', 'INACTIVE')")
    private ProductStatus productStatus = ProductStatus.ACTIVE;

    @OneToMany(mappedBy ="product")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy ="product")
    private List<Wishlist> wishlists;

    @OneToMany(mappedBy ="product")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "products")
    private List<Widget> widgets;

    public void addWidget(Widget widget){
        if(widgets==null){
            widgets= new ArrayList<>();
            widgets.add(widget);
        }
    }
    public void removeWidget(Widget widget){
        widgets.remove(widget);
    }


}


