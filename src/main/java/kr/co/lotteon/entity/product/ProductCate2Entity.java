package kr.co.lotteon.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int cate1;
    private int cate2;
    private String c2Name;
    
    public ProductCate2DTO toDTO(){
        return ProductCate2DTO.builder()
                .cate1(cate1)
                .cate2(cate2)
                .c2Name(c2Name)
                .build();
    }
}
