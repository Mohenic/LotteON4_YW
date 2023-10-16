package kr.co.lotteon.dto.product;

import jakarta.persistence.JoinColumn;
import kr.co.lotteon.entity.product.ProductCartEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCartDTO {

    private int cartNo;
    private String uid;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    private LocalDateTime rdate;


    public ProductCartEntity toEntity(){
         return ProductCartEntity.builder()
               .cartNo(cartNo)
               .uid(uid)
               .prodNo(prodNo)
               .count(count)
               .price(price)
               .discount(discount)
               .point(point)
               .delivery(delivery)
               .total(total)
               .rdate(rdate)
               .build();
    }
    
    

}
