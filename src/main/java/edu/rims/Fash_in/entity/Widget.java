package edu.rims.Fash_in.entity;

import java.util.ArrayList;
import java.util.List;

import edu.rims.Fash_in.constant.WidgetStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "widget")
@Getter
@Setter 

public class Widget extends Auditable {

    @Id
    @Column(name = "widget_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String widgetId;

    @Column(name = "widget_name", nullable = false)
    private String widgetName;

    @Enumerated(EnumType.STRING)
    private WidgetStatus widgetStatus = WidgetStatus.ACTIVE;

    @Column(name = "sequence")
    private Integer sequence;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "widget_product", joinColumns = @JoinColumn(name = "widget_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public void addProduct (Product product){
        if(product==null){
            products= new ArrayList<>();
        }
        product.addWidget(this);
        products.add(product);
    }

    // public void addProduct(Product product){
    //     if (products == null) {
    //         products = new ArrayList<>();
    //     }
    //     if (product != null) {
    //         product.addWidget(this);
    //         products.add(product);
    //     }
    // }

    public void removeProduct(String productId){
        for(Product product:products){
            if(product.getProductId().equals(productId)){
                product.removeWidget(this);
                products.remove(product);
                break;
            }
        }
    }

    public String getCategoryImageUrl() {
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryImageUrl'");
    }

    

}



