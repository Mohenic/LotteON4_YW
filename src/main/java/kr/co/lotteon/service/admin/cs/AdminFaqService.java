package kr.co.lotteon.service.admin.cs;

import kr.co.lotteon.dto.cs.CsArticleFaqDTO;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.mapper.admin.FaqMapper;
import kr.co.lotteon.repository.CsFaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminFaqService {

    private final FaqMapper mapper;
    private final CsFaqRepository csFaqRepository;


    // faq list

    public List<CsArticleFaqDTO> faqListAll(int start){
        return mapper.faqListAll(start);
    }

    public List<CsArticleFaqDTO> faqListCate(String cate2, String type, int start){
        return mapper.faqListCate(cate2,type,start);
    }

    public List<CsCate3Entity> faqListType(String cate2){

        log.info("1234...");

        log.info("mapper.FaqListType(cate2) : " + mapper.faqListType(cate2));

        return mapper.faqListType(cate2).stream().map(e -> e.toEntity()).toList();
    }

    public int selectCountTotal(){
        return mapper.selectCountTotal();
    }

    public int selectCountTotalCate(String cate2, String type){
        return mapper.selectCountTotalCate(cate2,type);
    }

    // faq delete

    public int faqListDelete(List<Integer> Nos) {
        int deletedCount = 0;

        for (Integer no : Nos) {
            List<CsArticleFaqEntity> csArticleFaqEntities = csFaqRepository.findByNo(no);

            if (csArticleFaqEntities != null && !csArticleFaqEntities.isEmpty()) {
                for (CsArticleFaqEntity csArticleFaqEntity : csArticleFaqEntities) {
                    csArticleFaqEntity.setUseyn("N"); // 변경할 필드 설정
                }

                // 변경된 엔티티 저장
                csFaqRepository.saveAll(csArticleFaqEntities);
                deletedCount += csArticleFaqEntities.size();
            }
        }

        return deletedCount; // 삭제된 엔티티 수 반환
    }

    // faq view

    public CsArticleFaqDTO faqView(int no){
        return mapper.faqView(no);
    }

    // faq write
    public void faqWrite(CsArticleFaqDTO dto, String regip){
        mapper.faqWrite(dto,regip);
    }

    // faq modify

    public void faqModify(CsArticleFaqDTO dto, String regip, int no){
        mapper.faqModify(dto,regip, no);
    }

}
