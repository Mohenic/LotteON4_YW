package kr.co.lotteon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lo_member")
public class MemberEntity {

    @Id
    private String uid;
    private String pass;
    private String name;
    private String gender;
    private String hp;
    private String email;
    private String type;
    private String point;
    private String level;
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
    private String wdate;
    private String rdate;
    private String etc1;
    private String etc2;
    private String etc3;
    private String etc4;
    private String etc5;

}
