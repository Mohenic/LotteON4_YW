package kr.co.lotteon.service;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.dto.cs.PageRequestDTO;
import kr.co.lotteon.dto.cs.PageResponseDTO;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.repository.CsCate3Repository;
import kr.co.lotteon.repository.CsNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsService {

    private final CsNoticeRepository csrepo;
    private final ModelMapper modelMapper;
    private final CsCate3Repository cs3repo;

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
                .dtoList(dtoList)
                .total(totalElement)
                .build();

    }
    
    public List<CsCate3Entity> selectCate2(String cate2){
        
        return cs3repo.findCsCate3EntitiesByCate2(cate2);
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
                .dtoList(dtoList)
                .total(totalElement)
                .build();

    }

}
