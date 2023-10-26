package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductOrderItemEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderItemDTO {
    
    private int ordNo;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    private String thumb1;
    private String prodName;
    private String company;
    private String ordUid;
    private LocalDateTime ordDate;
    private String ordStatus;
    private String prodCate1;
    private String prodCate2;
    private String seller;

    public ProductOrderItemEntity toEntity() {
        
        return ProductOrderItemEntity.builder()
                 .ordNo(ordNo)
                 .prodNo(prodNo)
                 .count(count)
                 .price(price)
                 .discount(discount)
                 .point(point)
                 .delivery(delivery)
                 .total(total)
                 .build();
                
    }
    
}
