package edu.rims.Fash_in.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import edu.rims.Fash_in.constant.WishlistStatus;

@Entity
@Table(name = "wishlist")
@Getter
@Setter
public class Wishlist extends Auditable {

    @Id
    @Column(name = "wishlist_id", length = 255)
    private String wishlistId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; 

     @Enumerated(EnumType.STRING)
    @Column(name = "Wishlist_Status", nullable = false, columnDefinition = "ENUM('ADDED','REMOVED','ACTIVE')")
    private  WishlistStatus wishlistStatus = WishlistStatus.ADDED;

   
}
