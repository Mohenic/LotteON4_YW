package kr.co.lotteon.dto;

import kr.co.lotteon.entity.MemberTermsEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberTermsDTO {
    private String terms;
    private String privacy;
    private String location;
    private String finance;
    private String tax;

    public MemberTermsEntity toEntity (){
        return MemberTermsEntity.builder()
                .terms(terms)
                .privacy(privacy)
                .location(location)
                .finance(finance)
                .tax(tax)
                .build();
    }

}
