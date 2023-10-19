package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.cs.CsCate2DTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CsMapper {

    public List<CsArticleQnaDTO> selectArticleAndCate();
    public CsArticleQnaDTO selectArticleNo(int no);

    public void updateArticle(CsArticleQnaDTO dto);

    public void deleteArticle(int no);

    public CsCate2DTO selectCate2(String cate2);

}
