package kr.co.lotteon.service.admin;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.mapper.AdminCSMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCSService {

    @Autowired
    private AdminCSMapper mapper;

    public List<CsArticleNoticeDTO> selectNoticeList(int start){
        return mapper.selectNoticeList(start);
    }
    public List<CsArticleNoticeDTO> NoticeListcs(int start){
        return mapper.NoticeListcs(start);
    }
    public List<CsArticleNoticeDTO> NoticeListsafety(int start){
        return mapper.NoticeListsafety(start);
    }
    public List<CsArticleNoticeDTO> NoticeListdanger(int start){
        return mapper.NoticeListdanger(start);
    }
    public List<CsArticleNoticeDTO> NoticeListeveresult(int start){
        return mapper.NoticeListeveresult(start);
    }

    public int selectCountTotal(){
        return mapper.selectCountTotal();
    }

}
