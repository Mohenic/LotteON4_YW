package kr.co.lotteon.entity.cs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.lotteon.dto.cs.CsCate1DTO;
import kr.co.lotteon.dto.cs.CsCate2DTO;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lo_cs_cate1")
public class CsCate1Entity {

    @Id
    private String cate1;
    private String detail;

    public CsCate1DTO toDTO(){
        return CsCate1DTO.builder()
                .cate1(cate1)
                .detail(detail)
                .build();
    }

}
