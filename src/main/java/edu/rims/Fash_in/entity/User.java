package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import edu.rims.Fash_in.constant.UserRole;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_phone", length = 20)
    private String userPhone;

    @Column(name = "user_address", columnDefinition = "TEXT")
    private String userAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole = UserRole.USER;
 
    @OneToMany(mappedBy ="user")
    private List<Order> orders;
}

