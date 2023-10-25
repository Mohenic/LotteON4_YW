package kr.co.lotteon.service.admin.cs;

import kr.co.lotteon.dto.admin.QnaReplyObject;
import kr.co.lotteon.dto.cs.CsArticleFaqDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.mapper.admin.QnaMapper;
import kr.co.lotteon.repository.CsQnaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminQnaService {

    private final QnaMapper mapper;
    private final CsQnaRepository csQnaRepository;
    private final SqlSession sqlSession;

    // faq list

    public List<CsArticleQnaDTO> qnaListAll(int start){
        return mapper.qnaListAll(start);
    }

    public List<CsArticleQnaDTO> qnaListCate(String cate2, String type, int start){
        return mapper.qnaListCate(cate2,type,start);
    }

    public List<CsCate3Entity> qnaListType(String cate2){

        log.info("1234...");

        log.info("mapper.FaqListType(cate2) : " + mapper.qnaListType(cate2));

        return mapper.qnaListType(cate2).stream().map(e -> e.toEntity()).toList();
    }

    public int selectCountTotal(){
        return mapper.selectCountTotal();
    }

    public int selectCountTotalCate(String cate2, String type){
        return mapper.selectCountTotalCate(cate2,type);
    }

    // qna delete

    public int qnaListDelete(List<Integer> Nos) {
        int deletedCount = 0;

        for (Integer no : Nos) {
            List<CsArticleQnaEntity> csArticleQnaEntities = csQnaRepository.findByNo(no);

            if (csArticleQnaEntities != null && !csArticleQnaEntities.isEmpty()) {
                for (CsArticleQnaEntity csArticleQnaEntity : csArticleQnaEntities) {
                    csArticleQnaEntity.setUseyn("N"); // 변경할 필드 설정
                    csArticleQnaEntity.setComment(0); // 변경할 필드 설정
                }

                // 변경된 엔티티 저장
                csQnaRepository.saveAll(csArticleQnaEntities);
                deletedCount += csArticleQnaEntities.size();
            }
        }

        return deletedCount; // 삭제된 엔티티 수 반환
    }

    // qna view

    public CsArticleQnaDTO qnaView(int no){
        return mapper.qnaView(no);
    }

    // qna reply

    @Transactional
    public void qnaReplyAndCommentUpdate(int parent, String cate1, String content, String writer, String regip) {

        // 댓글 추가
        sqlSession.insert("qnaReply", new QnaReplyObject(parent, cate1, content, writer, regip));

        // 부모 게시글의 comment 업데이트
        sqlSession.update("qnaReplyComment", parent);
    }

    public CsArticleQnaDTO qnaReplyView(int no){
        return mapper.qnaReplyView(no);
    }
}
