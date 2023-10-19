package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.cs.CsArticleQnaDTO;


import java.util.List;


public interface CsMapper {

    public List<CsArticleQnaDTO> selectArticleAndCate();


}
