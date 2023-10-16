package kr.co.lotteon.dto.cs;

import lombok.*;
import org.springframework.data.domain.*;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int pg=1;

    @Builder.Default
    private int size=10;

    private String cate1;
    private String cate2;

    @Builder.Default
    private String useyn="Y";

    public Pageable getPageable(String sort){
        return PageRequest.of(this.pg-1, this.size, Sort.by(sort).descending());
    }

}
