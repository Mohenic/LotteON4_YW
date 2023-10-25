package kr.co.lotteon.mapper.admin;

import kr.co.lotteon.dto.cs.CsArticleFaqDTO;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {


    // faq list
    public List<CsArticleFaqDTO> faqListAll(int start);
    public List<CsArticleFaqDTO> faqListCate(String cate2, String type, int start);
    public List<CsCate3DTO> faqListType (String cate2);

    public int selectCountTotal();
    public int selectCountTotalCate(String cate2, String type);

    // faq view

    public CsArticleFaqDTO faqView(int no);

    // faq write

    public void faqWrite(CsArticleFaqDTO dto, String regip);

    // faq modify

    public void faqModify(CsArticleFaqDTO dto, String regip, int no);

}
