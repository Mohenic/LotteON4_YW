package kr.co.lotteon.dto;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageRequestOrderDTO {

    @Builder.Default 
    private int pg=1;
    private String ordUid;

}
