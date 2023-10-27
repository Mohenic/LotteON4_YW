package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyinfoMapper {

    public MemberDTO myinfoList(String uid);
    public void myinfoModify(MemberDTO dto);

    public String passCheck(String uid);
    public void passUpdate(MemberDTO dto, String uid);

}
