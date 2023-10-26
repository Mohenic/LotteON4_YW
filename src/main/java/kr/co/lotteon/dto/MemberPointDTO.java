package kr.co.lotteon.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberPointDTO {
    private int pointNo;
    private String uid;
    private int ordNo;
    private int point;
    private LocalDate pointDate;
    private String descript;
}
