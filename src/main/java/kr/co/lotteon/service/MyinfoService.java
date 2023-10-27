package kr.co.lotteon.service;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.mapper.MyinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyinfoService {

    @Autowired
    private MyinfoMapper mapper;

    public MemberDTO myinfoList(String uid){
        return mapper.myinfoList(uid);
    }

    public void myinfoModify(MemberDTO dto){
        mapper.myinfoModify(dto);
    }

    public String passCheck (String uid){
        return mapper.passCheck(uid);
    }

    public void passUpdate(MemberDTO dto, String uid){
        mapper.passUpdate(dto,uid);
    }
}
