package kr.co.lotteon.dto.my;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyInfoDTO {




    private int point;
    private int count_b; //쿠폰 개수
    private int count_c; // 주문 개수
    private int count_d; // 문의 개수

}
