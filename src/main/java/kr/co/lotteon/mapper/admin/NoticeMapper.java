package kr.co.lotteon.mapper.admin;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // notice list
    public List<CsArticleNoticeDTO> selectNoticeList(int start);
    public List<CsArticleNoticeDTO> NoticeListcs(int start);
    public List<CsArticleNoticeDTO> NoticeListsafety(int start);
    public List<CsArticleNoticeDTO> NoticeListdanger(int start);
    public List<CsArticleNoticeDTO> NoticeListeveresult(int start);
    public int selectCountTotal();
    public int selectCountTotalCate(String cate2);

    // notice view

    public CsArticleNoticeDTO NoticeView(int no);

    // notice write

    public void NoticeWrite(CsArticleNoticeDTO dto, String regip);

    // notice modify

    public void NoticeModify(CsArticleNoticeDTO dto, String regip, int no);



}
