package kr.co.lotteon.dto;

import jakarta.persistence.Id;
import kr.co.lotteon.entity.MemberTermsEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberTermsDTO {
    private int no;
    private String terms;
    private String privacy;
    private String location;
    private String finance;
    private String tax;

    public MemberTermsEntity toEntity(){
        return MemberTermsEntity.builder()
                .no(no)
                .terms(terms)
                .privacy(privacy)
                .location(location)
                .finance(finance)
                .tax(tax)
                .build();
    }

}