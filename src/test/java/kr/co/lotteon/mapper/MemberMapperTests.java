package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.my.MyInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberMapperTests {


    @Autowired
    private MemberMapper memberMapper;


    @Test
    public void selectMyInfo2(){

        MyInfoDTO dto = memberMapper.selectMyInfo("user");
        System.out.println(dto);



    }

}
