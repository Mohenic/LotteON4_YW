package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductCate2Entity;
import lombok.*;

import java.util.List;

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
    private String c1Name;

    public <T> ProductCate2DTO(String cate1, List<T> c2Names) {
        this.cate1 = Integer.parseInt(cate1);
        this.c2Name = c2Names.toString();
    }

    public ProductCate2Entity toEntity() {
        return ProductCate2Entity.builder()
              .cate1(cate1)
              .cate2(cate2)
              .c2Name(c2Name)
              .build();
    }

}
