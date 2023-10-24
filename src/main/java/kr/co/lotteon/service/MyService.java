package kr.co.lotteon.service;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.PageRequestOrderDTO;
import kr.co.lotteon.dto.PageResponseOrderDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.entity.product.ProductOrderEntity;
import kr.co.lotteon.mapper.ProductOrderMapper;
import kr.co.lotteon.repository.MemberRepository;
import kr.co.lotteon.repository.product.ProductOrderRepository;
import kr.co.lotteon.util.Pager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MyService {

    private final ProductOrderMapper mapper;
    private final ProductOrderRepository productOrderRepository;

    public PageResponseOrderDTO order(PageRequestOrderDTO requestOrderDTO){
        log.info("ordUid : "+requestOrderDTO.getOrdUid());
        int total = productOrderRepository.countByOrdUid(requestOrderDTO.getOrdUid());
        PageResponseOrderDTO responseOrderDTO = new PageResponseOrderDTO(requestOrderDTO, total);
        List<ProductOrderDTO> dtoList = mapper.selectProductOrders(requestOrderDTO.getOrdUid(), responseOrderDTO.getStartNum());
        log.info("responseOrderDTO : "+responseOrderDTO);

        responseOrderDTO.setDtoList(dtoList);
        log.info("dtoList : "+responseOrderDTO.getDtoList());

        return responseOrderDTO;
    }

    /*public MemberDTO findMyInfo(String uid){
        return mapper.selectMyInfo(uid);
    }*/
}
