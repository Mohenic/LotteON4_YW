package kr.co.lotteon.dto;

import jakarta.persistence.Column;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.entity.MemberEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
/*
 * 날짜 : 2023.10.13
 * 이름 : 최정민
 * 내용 : MemberDTO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    private String uid;
    private String pass1;
    private String name;
    private int gender;
    private String hp;
    private String email;
    private int type;
    private int point;
    private int level;
    private String zip;
    private String addr1;
    private String addr2;
    private String company;
    private String ceo;
    private String bizRegNum;
    private String comRegNum;
    private String tel;
    private String manager;
    private String managerHp;
    private String fax;
    private String regip;
    private LocalDateTime wdate;
    private LocalDateTime rdate;
    private LocalDate birth;
    private LocalDate modidate;
    private String useyn;
    private String etc4;
    private String etc5;
    private String email1;
    private String email2;
    private String hp1;
    private String hp2;
    private String hp3;


    private ProductOrderDTO productOrderDTO;
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .uid(uid)
                .pass(pass1)
                .name(name)
                .gender(gender)
                .hp(hp)
                .email(email)
                .type(type)
                .point(point)
                .level(level==0?1:level)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .company(company)
                .ceo(ceo)
                .bizRegNum(bizRegNum)
                .comRegNum(comRegNum)
                .tel(tel)
                .manager(manager)
                .managerHp(managerHp)
                .fax(fax)
                .regip(regip)
                .wdate(wdate)
                .rdate(rdate)
                .birth(birth)
                .modidate(modidate)
                .useyn(useyn==null?"Y":useyn)
                .etc4(etc4)
                .etc5(etc5)
                .build();
    }

}