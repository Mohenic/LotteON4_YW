package kr.co.lotteon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"name","email","uid","division"})
public class RequestEmailDTO {
    private String division;
    private String name;
    private String uid;
    private String email;
}
