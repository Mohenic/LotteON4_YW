package kr.co.lotteon.entity.product;


import jakarta.persistence.*;
import kr.co.lotteon.dto.product.ProductReviewDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product_review")
@Entity
public class ProductReviewEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int revNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regip;
    private LocalDateTime rdate;
    private String useyn;
    
    public ProductReviewDTO toDTO(){
        return ProductReviewDTO.builder()
                .revNo(revNo)
                .prodNo(prodNo)
                .content(content)
                .uid(uid)
                .rating(rating)
                .regip(regip)
                .rdate(rdate)
                .useyn(useyn)
                .build();
    }
}
