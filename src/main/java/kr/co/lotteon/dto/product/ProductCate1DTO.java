package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductCate1Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString //exclude로 toString에 필요없는 컬럼을 제거할 수 있다 특히 리스트로 들어오는 것들을 제거하곤 한다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCate1DTO {

    private int cate1;
    private String c1Name;


    // 추가필드
    private List<ProductCate2DTO> cate2s;
    
    
    public ProductCate1Entity toEntity() {
        return ProductCate1Entity.builder()
              .cate1(cate1)
              .c1Name(c1Name)
              .build();
    }
    
}
