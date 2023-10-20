package kr.co.lotteon.entity.product;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import kr.co.lotteon.dto.product.ProductCate2DTO;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product_cate2")
@Entity
public class ProductCate2Entity {

    @Id
    private int cno;
    private int cate1;
    @NotNull
    private int cate2;
    @NotNull
    private String c2Name;
    
    public ProductCate2DTO toDTO(){
        return ProductCate2DTO.builder()
                .cno(cno)
                .cate1(cate1)
                .cate2(cate2)
                .c2Name(c2Name)
                .build();
    }
}
