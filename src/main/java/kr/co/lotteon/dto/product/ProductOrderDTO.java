package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductOrderEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDTO {

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
    
    public ProductOrderEntity toEntity() {
        return ProductOrderEntity.builder()
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
