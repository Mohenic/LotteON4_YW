package kr.co.lotteon.service;

import kr.co.lotteon.dao.CsDAO;
import kr.co.lotteon.dto.cs.*;
import kr.co.lotteon.entity.cs.*;
import kr.co.lotteon.mapper.CsMapper;
import kr.co.lotteon.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final CsCate2Repository cs2repo;

    @Autowired
    private CsMapper mapper;

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

    public List<CsCate3Entity> selectCate(){
        return cs3repo.findAll();
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

        Page<CsArticleQnaEntity> result =
                csqnarepo.findCsArticleQnaEntitiesByCate1AndCate2AndUseynAndParent(pageRequestDTO.getCate1(),
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

    public CsArticleQnaEntity selectCsArticleQnaComment(int no){
        CsArticleQnaEntity comment =csqnarepo.findCsArticleQnaEntitiesByParent(no);
        return comment;
    }

    public  CsArticleFaqEntity selectCsArticleFaq(int no){
        CsArticleFaqEntity faq =csfaqrepo.findCsArticleFaqEntitiesByNo(no);
        return  faq;
    }

    public CsArticleNoticeEntity selectCsArticleNotice(int no){
        CsArticleNoticeEntity notice = csrepo.findCsArticleNoticeEntitiesByNo(no);
        return notice;
    }

    public void insertQna(CsArticleQnaDTO dto){
        CsArticleQnaEntity entity = dto.toEntity();
        csqnarepo.save(entity);
    }

    public void updateQna(CsArticleQnaDTO dto){
        log.info("dto:"+dto);
        mapper.updateArticle(dto);

    }

    public List<CsCate2Entity> selectCate2Detail(){
       return cs2repo.findAll();

    }

    public List<CsArticleNoticeEntity> selectNoticeTop5Desc(){
        return csrepo.findTop5ByOrderByNoDesc();
    }

    public List<CsArticleQnaEntity> selectQnaTop5Desc(){
        return csqnarepo.findTop5ByOrderByNo();
    }

    public List<CsArticleQnaEntity> selectArticleAndCate(){
        List<CsArticleQnaEntity> entityList = mapper.selectQnaAndCate3().stream().map(e -> e.toEntity()).toList();
        log.info(entityList);

        return  entityList;

    }

    public CsArticleQnaEntity selectArticleNo(int no){
        CsArticleQnaEntity entity =mapper.selectArticleNo(no).toEntity();
        return entity;
    }

    public void deleteArticle(int no){
        mapper.deleteArticle(no);
    }

    public CsCate2Entity selectCate2Detail(String cate2){
        return mapper.selectCate2(cate2).toEntity();
    }

    public List<CsCate3Entity> selectCate3List(){
        return mapper.selectCate3().stream().map(e -> e.toEntity()).toList();
    }

    public List<CsArticleNoticeEntity> selectNoticeAndCate3(){
        return mapper.selectNoticeAndCate3().stream().map(e -> e.toEntity()).toList();
    }

    public List<CsArticleQnaEntity> selectQnaAndCate3(){

        return mapper.selectQnaAndCate3().stream().map(e -> e.toEntity()).toList();

    }

    public List<CsArticleQnaEntity> selectQnaAndCate3andJoin(){
        return mapper.selectQnaAndCate3andJoin().stream().map(e -> e.toEntity()).toList();
    }

}
