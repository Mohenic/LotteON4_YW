package kr.co.lotteon.mapper.admin;

import kr.co.lotteon.dto.cs.CsArticleFaqDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {

    // qna list
    public List<CsArticleQnaDTO> qnaListAll(int start);
    public List<CsArticleQnaDTO> qnaListCate(String cate2, String type, int start);
    public List<CsCate3DTO> qnaListType (String cate2);

    public int selectCountTotal();
    public int selectCountTotalCate(String cate2, String type);

    // qna view

    public CsArticleQnaDTO qnaView(int no);

    // qna reply
    public void qnaReplyAndCommentUpdate(int parent, String cate1, String content, String writer, String regip);
    public CsArticleQnaDTO qnaReplyView(int no);

}
