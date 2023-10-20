package kr.co.lotteon.entity.product;


import jakarta.persistence.*;
import kr.co.lotteon.dto.product.ProductDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lo_product")
@Entity

public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @CreationTimestamp
    private LocalDateTime rdate;

    @Builder.Default
    private String useyn="Y";

    private int etc1;
    private int etc2;
    private String etc4;
    private String etc5;
    
    public ProductDTO toDTO(){
        return ProductDTO.builder()
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
              .useyn(useyn)
              .etc1(etc1)
              .etc2(etc2)
              .etc4(etc4)
              .etc5(etc5)
                .thumb1(thumb1)
                .thumb2(thumb2)
                .thumb2(thumb3)
              .build();
        
    }
    public int getDiscountPrice(int price, int discount) {
        int discountPrice=0;

        discountPrice=(int)(price-(price*(discount*0.01)));

        return discountPrice;
    }

    public String getDiscount(int price, int discount) {

        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(getDiscountPrice(price, discount));
    }
    public int getDiscountPrice2(int price, int discount) {
        int discountPrice=0;

        discountPrice=(int)(price*(discount*0.01));

        return discountPrice;
    }

    public String getDiscount2(int price, int discount) {

        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(getDiscountPrice2(price, discount));
    }
}
