package kr.co.lotteon.dto.my;

import jakarta.persistence.*;
import kr.co.lotteon.entity.my.CouponEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponDTO {


    private int couponno;
    private String cName;
    private String cuid;
    private int cPrice;
    private int climit;
    private LocalDateTime issueddate;
    private LocalDateTime enddate;
    private int cstatus;

    public CouponEntity toEntity(){
        return CouponEntity.builder()
              .couponno(couponno)
              .cName(cName)
                .cuid(cuid)
              .cPrice(cPrice)
              .climit(climit)
              .issueddate(issueddate)
              .enddate(enddate)
              .cstatus(cstatus)
              .build();
    }

}
