package kr.co.lotteon.entity.my;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import kr.co.lotteon.dto.my.CouponDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="lo_my_coupon")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponno;

    private String cName;
    private String cuid;
    private int cPrice;
    private int climit;

    @CreationTimestamp
    private LocalDateTime issueddate;

    private LocalDateTime enddate;

    private int cstatus;


    public CouponDTO toDTO(){
        return CouponDTO.builder()
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

    public String getPrice(int cprice) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(cprice);
    }

    public String getClimit(int climit) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(climit);
    }

}
