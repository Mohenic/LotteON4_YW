package kr.co.lotteon.entity.product;

import jakarta.persistence.*;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product_order")
@Entity
public class ProductOrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordNo;
    private String ordUid;
    private int ordCount;
    private int ordPrice;
    private int ordDiscount;
    private int ordDelivery;
    private int savePoint;
    private int usedPoint;
    private int ordTotPrice;
    private String recipName;
    private String recipHp;
    private String recipZip;
    private String recipAddr1;
    private String recipAddr2;
    private int ordPayment;
    private int ordComplete;
    private LocalDateTime ordDate;
    
    
    public ProductOrderDTO toDTO(){
        return ProductOrderDTO.builder()
              .ordNo(ordNo)
              .ordUid(ordUid)
              .ordCount(ordCount)
              .ordPrice(ordPrice)
              .ordDiscount(ordDiscount)
              .ordDelivery(ordDelivery)
              .savePoint(savePoint)
              .usedPoint(usedPoint)
              .ordTotPrice(ordTotPrice)
              .recipName(recipName)
              .recipHp(recipHp)
              .recipZip(recipZip)
              .recipAddr1(recipAddr1)
              .recipAddr2(recipAddr2)
              .ordPayment(ordPayment)
              .ordComplete(ordComplete)
              .ordDate(ordDate)
              .build();
    }
}
