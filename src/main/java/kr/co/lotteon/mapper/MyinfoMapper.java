package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyinfoMapper {

    public MemberDTO myinfoList(String uid);

}
