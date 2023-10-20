package kr.co.lotteon.dto.product;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageRequestDTO {

    @Builder.Default 
    private int pg=1;

    @Builder.Default
    private int size=10;

    private int prodCate1;
    private int prodCate2;

    private int prodNo;

    @Builder.Default
    private String useyn="Y";

    @Builder.Default
    private String sort = "prodNo";

    @Builder.Default
    private String orderBy = "D";

    //desc
    public Pageable getPageableD(String sort){
        sort = this.sort;
        return PageRequest.of(this.pg-1, this.size, Sort.by(sort).descending());
    }
    public Pageable getPageableA(String sort){
        sort = this.sort;
        return PageRequest.of(this.pg-1, this.size, Sort.by(sort));
    }


}
