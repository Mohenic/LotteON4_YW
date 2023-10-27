package kr.co.lotteon.dto.my;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageRequestOrderDTO {

    private String dateType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;


    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate = LocalDate.now();

    @Builder.Default 
    private int pg=1;
    private String ordUid;

    public void getBeginDate(String dateType){
        this.dateType = dateType;
        LocalDate beginDate=null;
        // 현재 날짜와 시간
        LocalDate currentDate = LocalDate.now();
        if(dateType.equals("day7")){
            // 1주일 전 날짜와 시간
            beginDate = currentDate.minusWeeks(1);
        }else if(dateType.equals("day15")){
            // 15일 전 날짜와 시간
            beginDate = currentDate.minusDays(15);
        }else if(dateType.equals("month1")){
            // 한 달 전 날짜와 시간
            beginDate = currentDate.minusMonths(1);
        }else if(dateType.equals("period")){
            beginDate = this.beginDate;
        }else if(dateType.equals("month_0")){
            beginDate = currentDate.withDayOfMonth(1);
            this.endDate = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        }else if(dateType.equals("month_1")){
            beginDate = currentDate.minusMonths(1).withDayOfMonth(1);
            this.endDate = currentDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        }else if(dateType.equals("month_2")){
            beginDate = currentDate.minusMonths(2).withDayOfMonth(1);
            this.endDate = currentDate.minusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        }else if(dateType.equals("month_3")){
            beginDate = currentDate.minusMonths(3).withDayOfMonth(1);
            this.endDate = currentDate.minusMonths(3).with(TemporalAdjusters.lastDayOfMonth());
        }else if(dateType.equals("month_4")){
            beginDate = currentDate.minusMonths(4).withDayOfMonth(1);
            this.endDate = currentDate.minusMonths(4).with(TemporalAdjusters.lastDayOfMonth());
        }
        this.beginDate = beginDate;
    }
}
