package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.my.MyInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public MyInfoDTO selectMyInfo(String uid);

}
