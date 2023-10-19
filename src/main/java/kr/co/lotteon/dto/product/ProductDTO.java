package kr.co.lotteon.dto.product;

import kr.co.lotteon.entity.product.ProductEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile fileThumb1;
    private MultipartFile fileThumb2;
    private MultipartFile fileThumb3;
    private MultipartFile fileDetail;
    private String Thumb1;
    private String Thumb2;
    private String Thumb3;
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

    // 추가필드
    private String thumb1;
    private String thumb2;
    private String thumb3;
    private String detail;
    
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
                .status(status)
                .duty(duty)
                .receipt(receipt)
                .bizType(bizType)
                .origin(origin)
                .ip(ip)
                .rdate(rdate)
                .useyn(useyn == null ? "Y" : "")
                .thumb1(Thumb1)
                .thumb2(Thumb2)
                .thumb3(Thumb3)
                .build();
    }
    
}
