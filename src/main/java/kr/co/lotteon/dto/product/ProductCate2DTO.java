package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductCate2Entity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCate2DTO {

    private int cno;
    private int cate1;
    private int cate2;
    private String c2Name;

    public ProductCate2Entity toEntity() {
        return ProductCate2Entity.builder()
              .cate1(cate1)
              .cate2(cate2)
              .c2Name(c2Name)
              .build();
    }

}
