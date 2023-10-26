package kr.co.lotteon.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyNoticeDTO {

    private int no;
    private String title;
    private String content;
    private LocalDateTime rdate;

}
