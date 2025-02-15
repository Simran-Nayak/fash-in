package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import edu.rims.Fash_in.constant.PaymentStatus;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment extends Auditable {

    @Id
    @Column(name = "payment_id", length = 255)
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "amount_paid", nullable = false)
    private double amountPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "payments", nullable = false, columnDefinition = "ENUM('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED') DEFAULT 'PENDING'")
    private PaymentStatus Paymentstatus = PaymentStatus.PENDING; 

    @Column(name = "transaction_id", unique = true, length = 255)
    private String transactionId;

  
}

