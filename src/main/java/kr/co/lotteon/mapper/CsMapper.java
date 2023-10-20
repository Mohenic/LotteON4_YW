package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.cs.CsCate2DTO;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CsMapper {

    public List<CsArticleQnaDTO> selectQnaAndCate3();
    public CsArticleQnaDTO selectArticleNo(int no);

    public void updateArticle(CsArticleQnaDTO dto);

    public void deleteArticle(int no);

    public CsCate2DTO selectCate2(String cate2);


    public List<CsArticleNoticeDTO> selectNoticeAndCate3();

    public List<CsCate3DTO> selectCate3();

    public List<CsArticleQnaDTO> selectQnaAndCate3andJoin();



}
