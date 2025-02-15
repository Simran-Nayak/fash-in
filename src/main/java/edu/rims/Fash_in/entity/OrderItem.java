package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import edu.rims.Fash_in.constant.OrderItemStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
@Getter
@Setter

public class OrderItem extends Auditable {

    @Id
    @Column(name = "order_item_id", length = 255)
    private String orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "order_item_unit_price", nullable = false)
    private double orderItemUnitPrice;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

     @Enumerated(EnumType.STRING)
    @Column(name = "OrderItem_status", nullable = false, columnDefinition = "ENUM('PENDING', 'SHIPPED','DELIEVERED','CANCELLED')")
    private OrderItemStatus orderItemStatus = OrderItemStatus.PENDING;
}

