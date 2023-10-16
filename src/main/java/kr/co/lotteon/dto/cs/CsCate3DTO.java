package kr.co.lotteon.dto.cs;

import kr.co.lotteon.entity.cs.CsCate3Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CsCate3DTO {

    private String cate2;
    private String cate3;
    private String detail;

    public CsCate3Entity toEntity(){
        return CsCate3Entity.builder()
                .cate2(cate2)
                .cate3(cate3)
                .detail(detail)
                .build();
    }


}
