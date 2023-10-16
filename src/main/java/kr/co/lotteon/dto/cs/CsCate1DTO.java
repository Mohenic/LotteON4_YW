package kr.co.lotteon.dto.cs;

import kr.co.lotteon.entity.cs.CsCate1Entity;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CsCate1DTO {

    private String cate1;

    private String detail;

    public CsCate1Entity toEntity(){
        return CsCate1Entity.builder()
                .cate1(cate1)
                .detail(detail)
                .build();
    }


}
