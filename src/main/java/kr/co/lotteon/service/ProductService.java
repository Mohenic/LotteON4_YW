package kr.co.lotteon.service;

import kr.co.lotteon.dto.product.PageRequestDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository prodrepo;
    private final ModelMapper modelMapper;

    public PageResponseDTO findByCate1Product(PageRequestDTO pageRequestDTO) {
        
        Pageable pageable = pageRequestDTO.getPageable("prodNo"); // Pageable 가져오는 방법 수정

        Page<ProductEntity> result = prodrepo.findAllByprodCate1(pageRequestDTO.getCate1(), pageable); //

        log.info("result.getTotalElements():" + result.getTotalElements()); // 100
        log.info("result.getContent():" + result.getContent()); // 100
        
        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class)) // ModelMapper 사용 방법 수정
                .toList();
    
        log.info("dtoList.size():" + dtoList.size()); // 10
        log.info("dtoList:" + dtoList); // 100
        log.info(""+dtoList.get(0).getProdNo()); // 100
        
        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO) // pageRequestDTO 수정
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

}