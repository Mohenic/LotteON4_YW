package kr.co.lotteon.entity.product;


import jakarta.persistence.*;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.cs.CsCate1DTO;
import kr.co.lotteon.dto.product.ProductCartDTO;
import kr.co.lotteon.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product_cart")
@Entity
public class ProductCartEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartNo;
   // @JoinColumn(name = "member_id", column)
    private String uid;
   // @JoinColumn(name = "prod_no")
    //private ProductEntity prodNo;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    private LocalDateTime rdate;


    public ProductCartDTO toDTO(){
        return ProductCartDTO.builder()
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
