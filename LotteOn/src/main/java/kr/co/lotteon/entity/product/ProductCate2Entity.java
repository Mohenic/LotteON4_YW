package kr.co.lotteon.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
