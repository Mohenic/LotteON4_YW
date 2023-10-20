package kr.co.lotteon.service;

import kr.co.lotteon.dto.product.*;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.repository.product.ProductCate1Repository;
import kr.co.lotteon.repository.product.ProductRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository prodrepo;
    private final ProductCate1Repository prodCate1Repo;
    private final ModelMapper modelMapper;

    public PageResponseDTO findByCate1Product(PageRequestDTO pageRequestDTO) {

        log.info("pageRequestDTO.getCate1():" + pageRequestDTO.getProdCate1());
        log.info("pageRequestDTO.getCate1():" + pageRequestDTO.toString());
        Pageable pageable;
            if(pageRequestDTO.getOrderBy().equals("A")) {
                pageable = pageRequestDTO.getPageableA(pageRequestDTO.getSort()); // Pageable 가져오는 방법 수정
            }else {
                pageable = pageRequestDTO.getPageableD(pageRequestDTO.getSort()); // Pageable 가져오는 방법 수정
            }


        log.info("pageRequestDTO.getCate1():" + pageRequestDTO.getProdCate1());
        
        
        Page<ProductEntity> result = prodrepo.findProductEntitiesByprodCate1(pageRequestDTO.getProdCate1(), pageable); //

        log.info("result" + result); // 100
        log.info("result.getTotalElements():" + result.getTotalElements()); // 100
        log.info("result.getContent():" + result.getContent()); // 100
        
        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class)) // ModelMapper 사용 방법 수정 //map.()의 파라미터중 앞에는 소스 뒤는 목적하는 타겟의 타입을 명시
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

 /*   public ProductCate2DTO findByProductIndexCate(ProductCate2DTO cate2DTO) {
        
        
        //return prodCate1Repo.findProductIndexCateByprodCate1(cate2DTO);
        return null;
        
    }*/

    public List<ProductCate1DTO> getAllProdCate1() {
        
        List<ProductCate1DTO> prodCate1DTO = prodCate1Repo.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductCate1DTO.class))
                .toList();
        log.info("prodCate1DTO:" + prodCate1DTO);


        return prodCate1DTO;
    }
    
    public List<ProductEntity> getAllProduct(int prodNo) {
     
        log.info("prodNo:" + prodNo);
        
        List<ProductEntity> productEntity = prodrepo.findByProdNo(prodNo);
        log.info("productEntity:" + productEntity);

        return productEntity;
    }
    
    
}