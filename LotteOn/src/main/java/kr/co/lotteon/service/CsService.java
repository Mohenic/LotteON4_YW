package kr.co.lotteon.service;

import kr.co.lotteon.dto.cs.CsArticleDTO;
import kr.co.lotteon.dto.cs.PageRequestDTO;
import kr.co.lotteon.dto.cs.PageResponseDTO;
import kr.co.lotteon.entity.cs.CsArticleEntity;
import kr.co.lotteon.repository.CsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsService {

    private final CsRepository csrepo;
    private final ModelMapper modelMapper;

    public PageResponseDTO selectCate1(PageRequestDTO pageRequestDTO){

        Pageable pageable =pageRequestDTO.getPageable("no");

        Page<CsArticleEntity> result =csrepo.findCsArticleEntitiesByCate1AndUseynAndParent(pageRequestDTO.getCate1(), "Y",0,pageable);

        List<CsArticleDTO> dtoList =result.getContent()
                .stream()
                .map(e-> modelMapper.map(e,CsArticleDTO.class))
                .toList();

        int totalElement =(int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();

    }

    public PageResponseDTO  selectCate1AndCate2(PageRequestDTO pageRequestDTO){

        Pageable pageable =pageRequestDTO.getPageable("no");

        Page<CsArticleEntity> result =csrepo.findCsArticleEntitiesByCate1AndCate2AndUseynAndParent(pageRequestDTO.getCate1(),
                pageRequestDTO.getCate2()
                ,"Y",0,pageable);

        List<CsArticleDTO> dtoList =result.getContent()
                .stream()
                .map(e->modelMapper.map(e,CsArticleDTO.class))
                .toList();

        int totalElement =(int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();

    }

}
