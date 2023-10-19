package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCSMapper {
    public List<CsArticleNoticeDTO> selectNoticeList(int start);
    public List<CsArticleNoticeDTO> NoticeListcs(int start);
    public List<CsArticleNoticeDTO> NoticeListsafety(int start);
    public List<CsArticleNoticeDTO> NoticeListdanger(int start);
    public List<CsArticleNoticeDTO> NoticeListeveresult(int start);
    public int selectCountTotal();

}
