package kr.co.lotteon.entity.product;

import jakarta.persistence.*;
import kr.co.lotteon.dto.product.ProductCate1DTO;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product_cate1")
@Entity
public class ProductCate1Entity {
    
    @Id
    //@OneToMany(mappedBy = "productCate1")
    private int cate1;
    private String c1Name;
    
    public ProductCate1DTO toDTO() {
        return ProductCate1DTO.builder()
                .cate1(cate1)
                .c1Name(c1Name)
                .build();
        
    }
    
    
    
}
