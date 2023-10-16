package kr.co.lotteon.entity;

import jakarta.persistence.*;
import kr.co.lotteon.dto.MemberTermsDTO;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lo_member_terms")
public class MemberTermsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String terms;
    private String privacy;
    private String location;
    private String finance;
    private String tax;

    public MemberTermsDTO toDTO(){
        return MemberTermsDTO.builder()
                .no(no)
                .terms(terms)
                .privacy(privacy)
                .location(location)
                .finance(finance)
                .tax(tax)
                .build();
    }

}
