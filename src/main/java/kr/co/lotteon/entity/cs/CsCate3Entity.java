package kr.co.lotteon.entity.cs;

import jakarta.persistence.*;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lo_cs_cate3")
public class CsCate3Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    private String cate2;
    private String cate3;
    private String detail;

    public CsCate3DTO toDTO(){
        return CsCate3DTO.builder()
                .cate2(cate2)
                .cate3(cate3)
                .detail(detail)
                .build();
    }

}
