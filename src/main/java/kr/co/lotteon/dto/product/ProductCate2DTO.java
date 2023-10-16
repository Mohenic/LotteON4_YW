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
    
    private int cate1;
    private int cate2;
    private String c2Name;

    
<<<<<<< HEAD
    /*public ProductCate2DTO toEntity() {}*/
=======
    public ProductCate2Entity toEntity() {
        return ProductCate2Entity.builder()
              .cate1(cate1)
              .cate2(cate2)
              .c2Name(c2Name)
              .build();
    }
>>>>>>> 80022b3320e1f7be895590d96e49ebf272bace44
    
}
