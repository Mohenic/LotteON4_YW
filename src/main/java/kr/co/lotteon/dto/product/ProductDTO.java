package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int prodNo;
    private int prodCate1;
    private int prodCate2;
    private String prodName;
    private String descript;
    private String seller;
    private String company;
    private int price;
    private int discount;
    private int point;
    private int stock;
    private int sold;
    private int delivery;
    private int hit;
    private int score;
    private int review;
    private String thumb1;
    private String thumb2;
    private String thumb3;
    private String detail;
    private String status;
    private String duty;
    private String receipt;
    private String bizType;
    private String origin;
    private String ip;
    private LocalDateTime rdate;
    private String useyn;
    private int etc1;
    private int etc2;
    private String etc4;
    private String etc5;
    
    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .prodNo(prodNo)
                .prodCate1(prodCate1)
                .prodCate2(prodCate2)
                .prodName(prodName)
                .descript(descript)
                .seller(seller)
                .company(company)
                .price(price)
                .discount(discount)
                .point(point)
                .stock(stock)
                .sold(sold)
                .delivery(delivery)
                .hit(hit)
                .score(score)
                .review(review)
                .thumb1(thumb1)
                .thumb2(thumb2)
                .thumb3(thumb3)
                .detail(detail)
                .status(status)
                .duty(duty)
                .receipt(receipt)
                .bizType(bizType)
                .origin(origin)
                .ip(ip)
                .rdate(rdate)
                .useyn(useyn)
                .build();
    }
    
}
