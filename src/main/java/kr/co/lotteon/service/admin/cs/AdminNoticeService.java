package kr.co.lotteon.service.admin.cs;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.mapper.admin.NoticeMapper;
import kr.co.lotteon.repository.CsNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminNoticeService {

    private final NoticeMapper mapper;
    private final CsNoticeRepository csNoticeRepository;


    // notice list
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

    public int selectCountTotalCate(String cate2){
        return mapper.selectCountTotalCate(cate2);
    }

    // notice delete

    public int deleteByNo(List<Integer> Nos) {
        int deletedCount = 0;

        for (Integer no : Nos) {
            List<CsArticleNoticeEntity> CsArticleNoticeEntities = csNoticeRepository.findByNo(no);

            if (CsArticleNoticeEntities != null && !CsArticleNoticeEntities.isEmpty()) {
                for (CsArticleNoticeEntity csArticleNoticeEntity : CsArticleNoticeEntities) {
                    csArticleNoticeEntity.setUseyn("N"); // 변경할 필드 설정
                }

                // 변경된 엔티티 저장
                csNoticeRepository.saveAll(CsArticleNoticeEntities);
                deletedCount += CsArticleNoticeEntities.size();
            }
        }

        return deletedCount; // 삭제된 엔티티 수 반환
    }

    // notice view

    public CsArticleNoticeDTO NoticeView(int no){
        return mapper.NoticeView(no);
    }

    // notice write
    public void NoticeWrite(CsArticleNoticeDTO dto, String regip){
        mapper.NoticeWrite(dto,regip);
    }

    // notice modify

    public void NoticeModify(CsArticleNoticeDTO dto, String regip, int no){
        mapper.NoticeModify(dto,regip, no);
    }

}
