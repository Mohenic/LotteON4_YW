package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductCate1Entity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCate1DTO {

    private int cate1;
    private String c1Name;
    
    public ProductCate1Entity toEntity() {
        return ProductCate1Entity.builder()
              .cate1(cate1)
              .c1Name(c1Name)
              .build();
    }
    
}
