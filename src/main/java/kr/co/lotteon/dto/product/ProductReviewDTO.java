package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductReviewEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDTO {

    private int revNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regip;
    private LocalDateTime rdate;
    private String useyn;
    
    public ProductReviewEntity toEntity() {
        return ProductReviewEntity.builder()
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
