package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import edu.rims.Fash_in.constant.OrderStatus;


@Entity
@Table(name = "Orders")
@Getter
@Setter

public class Order extends Auditable {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)   
    private OrderStatus orderStatus = OrderStatus.PENDING;

}

