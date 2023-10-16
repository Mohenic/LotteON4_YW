package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductOrderItemEntity;
import lombok.*;

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
