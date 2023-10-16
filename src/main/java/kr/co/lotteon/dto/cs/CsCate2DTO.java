package kr.co.lotteon.dto.cs;

import kr.co.lotteon.entity.cs.CsCate1Entity;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CsCate2DTO {

    private String cate2;
    private String detail;

    public CsCate2Entity toEntity(){
        return CsCate2Entity.builder()
                .cate2(cate2)
                .detail(detail)
                .build();
    }


}
