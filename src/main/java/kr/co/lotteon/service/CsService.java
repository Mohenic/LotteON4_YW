package kr.co.lotteon.service;

import kr.co.lotteon.dto.cs.*;
import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.repository.CsCate3Repository;
import kr.co.lotteon.repository.CsFaqRepository;
import kr.co.lotteon.repository.CsNoticeRepository;
import kr.co.lotteon.repository.CsQnaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CsService {

    private final CsNoticeRepository csrepo;
    private final ModelMapper modelMapper;
    private final CsCate3Repository cs3repo;
    private final CsQnaRepository csqnarepo;
    private final CsFaqRepository csfaqrepo;


    public PageResponseDTO selectCate1(PageRequestDTO pageRequestDTO){

        Pageable pageable =pageRequestDTO.getPageable("no");

        Page<CsArticleNoticeEntity> result =csrepo.findCsArticleNoticeEntitiesByCate1AndUseynAndParent(pageRequestDTO.getCate1(), "Y",0,pageable);

        List<CsArticleNoticeDTO> dtoList =result.getContent()
                .stream()
                .map(e-> modelMapper.map(e, CsArticleNoticeDTO.class))
                .toList();

        int totalElement =(int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList1(dtoList)
                .total(totalElement)
                .build();

    }



    
    public List<CsCate3Entity> selectCate2(String cate2){
        List<CsCate3Entity> result=cs3repo.findCsCate3EntitiesByCate2(cate2);
        log.info(result);
        return result;
    }

    public List<CsCate3Entity> selectCate(String cate2){

        log.info("result : ");
        return null;
    }

    public PageResponseDTO  selectCate1AndCate2(PageRequestDTO pageRequestDTO){

        Pageable pageable =pageRequestDTO.getPageable("no");

        Page<CsArticleNoticeEntity> result =csrepo.findCsArticleNoticeEntitieByCate1AndCate2AndUseynAndParent(pageRequestDTO.getCate1(),
                pageRequestDTO.getCate2()
                ,"Y",0,pageable);

        List<CsArticleNoticeDTO> dtoList =result.getContent()
                .stream()
                .map(e->modelMapper.map(e, CsArticleNoticeDTO.class))
                .toList();

        int totalElement =(int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList1(dtoList)
                .total(totalElement)
                .build();

    }

    public PageResponse2DTO  selectQnaCate1AndCate2(PageRequestDTO pageRequestDTO){

        Pageable pageable =pageRequestDTO.getPageable("no");

        Page<CsArticleQnaEntity> result =csqnarepo.findCsArticleQnaEntitiesByCate1AndCate2AndUseynAndParent(pageRequestDTO.getCate1(),
                pageRequestDTO.getCate2()
                ,"Y",0,pageable);

        List<CsArticleQnaDTO> dtoList =result.getContent()
                .stream()
                .map(e->modelMapper.map(e, CsArticleQnaDTO.class))
                .toList();

        int totalElement =(int) result.getTotalElements();

        return PageResponse2DTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();

    }

    public List<CsArticleFaqEntity> selectFaqArticles(String cate1,String cate2){

         return csfaqrepo.findByCate1AndCate2AndUseynAndParent(cate1,cate2,"Y",0);
    }

    public CsArticleQnaEntity selectCsArticleQna(int no){
        CsArticleQnaEntity qna=csqnarepo.findCsArticleQnaEntitiesByNo(no);
        return qna;
    }

    public  CsArticleFaqEntity selectCsArticleFaq(int no){
        CsArticleFaqEntity faq =csfaqrepo.findCsArticleFaqEntitiesByNo(no);
        return  faq;
    }

    public CsArticleNoticeEntity selectCsArticleNotice(int no){
        CsArticleNoticeEntity notice = csrepo.findCsArticleNoticeEntitiesByNo(no);
        return notice;
    }

}
