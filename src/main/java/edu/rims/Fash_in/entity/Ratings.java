package edu.rims.Fash_in.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import edu.rims.Fash_in.constant.Rating;

@Entity
@Table(name = "ratings")
@Getter
@Setter

public class Ratings {

    @Id
    @Column(name = "review_id", length = 255)
    private String reviewId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  

    @Enumerated(EnumType.STRING)
    @Column(name = "rating", nullable = false, columnDefinition = "ENUM('ONE','TWO','THREE','FOUR','FIVE')")
    private Rating rating = Rating.ONE;

    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;
}
