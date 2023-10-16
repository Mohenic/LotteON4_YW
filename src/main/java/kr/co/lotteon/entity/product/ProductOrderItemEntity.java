package kr.co.lotteon.entity.product;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product_order_item")
@Entity
public class ProductOrderItemEntity {

    @Id
    private int ordNo;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    
    public ProductOrderItemDTO toDTO() {
        return ProductOrderItemDTO.builder()
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

