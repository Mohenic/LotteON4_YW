package kr.co.lotteon.entity.cs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.lotteon.dto.cs.CsCate2DTO;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lo_cs_cate2")
public class CsCate2Entity {

    @Id
    private String cate2;
    private String detail;

    public CsCate2DTO toDTO(){
        return CsCate2DTO.builder()
                .cate2(cate2)
                .detail(detail)
                .build();
    }

}
