package kr.co.lotteon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.lotteon.dto.MemberDTO;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
/*
 * 날짜 : 2023.10.13
 * 이름 : 최정민
 * 내용 : MemberEntity
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "lo_member")
public class MemberEntity {

    @Id
    private String uid;
    private String pass;
    private String name;
    private int gender;
    @Column(name = "hp", unique = true)
    private String hp;
    @Column(name = "email", unique = true)
    private String email;
    private int type;
    @Builder.Default
    private int point = 0;
    // 기본값 적용 안됨
    @Builder.Default
    private int level=1;
    private String zip;
    private String addr1;
    private String addr2;
    private String company;
    private String ceo;
    private String bizRegNum;
    private String comRegNum;
    private String tel;
    private String manager;
    @Column(name = "managerHp", unique = true)
    private String managerHp;
    private String fax;
    private String regip;
    private LocalDateTime wdate;
    @CreationTimestamp
    private LocalDateTime rdate;
    private String etc1;
    private String etc2;
    private String etc3;
    private String etc4;
    private String etc5;

    public MemberDTO toDTO(){
        return MemberDTO.builder()
                .uid(uid)
                .pass1(pass)
                .name(name)
                .gender(gender)
                .hp(hp)
                .email(email)
                .type(type)
                .point(point)
                .level(level)
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
                .etc1(etc1)
                .etc2(etc2)
                .etc3(etc3)
                .etc4(etc4)
                .etc5(etc5)
                .build();
    }

}
