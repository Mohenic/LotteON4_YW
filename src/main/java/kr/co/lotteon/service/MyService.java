package kr.co.lotteon.service;

import kr.co.lotteon.dto.*;
import kr.co.lotteon.dto.my.*;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.mapper.MemberMapper;
import kr.co.lotteon.mapper.MemberPointMapper;
import kr.co.lotteon.mapper.ProductOrderMapper;
import kr.co.lotteon.repository.MemberPointRepository;
import kr.co.lotteon.repository.product.ProductOrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MyService {

    private final ProductOrderMapper orderMapper;
    private final MemberMapper memberMapper;
    private final MemberPointMapper pointMapper;
    private final ProductOrderItemRepository productOrderItemRepository;
    private final MemberPointRepository memberPointRepository;
    public PageResponseOrderDTO order(PageRequestOrderDTO requestOrderDTO){
        log.info("requestOrderDTO.getDateType() : "+requestOrderDTO.getDateType());
        PageResponseOrderDTO responseOrderDTO=null;
        if(requestOrderDTO.getDateType() == null||requestOrderDTO.getDateType().equals("")){
            log.info("ordUid : "+requestOrderDTO.getOrdUid());
            int total = productOrderItemRepository.countByOrdUid(requestOrderDTO.getOrdUid());
            log.info("total : "+total);
            responseOrderDTO = new PageResponseOrderDTO(requestOrderDTO, total);
            log.info("responseOrderDTO.getStartNum : "+responseOrderDTO.getStartNum());
            log.info("requestOrderDTO.getOrdUid() : "+requestOrderDTO.getOrdUid());
            List<ProductOrderDTO> dtoList = orderMapper.selectProductOrders(requestOrderDTO.getOrdUid(), responseOrderDTO.getStartNum());
            log.info("responseOrderDTO : "+responseOrderDTO);
            responseOrderDTO.setDtoList(dtoList);
            log.info("dtoList : "+responseOrderDTO.getDtoList());
        }else{
            requestOrderDTO.getBeginDate(requestOrderDTO.getDateType());

            log.info("ordUid : "+requestOrderDTO.getOrdUid());
            log.info("beginDate : "+requestOrderDTO.getBeginDate());
            log.info("EndDate : "+requestOrderDTO.getEndDate());

            int total = productOrderItemRepository.countByOrdUidAndOrdDateGreaterThanEqualAndOrdDateLessThanEqual(requestOrderDTO.getOrdUid(), requestOrderDTO.getBeginDate(), requestOrderDTO.getEndDate());
            responseOrderDTO = new PageResponseOrderDTO(requestOrderDTO, total);
            List<ProductOrderDTO> dtoList = orderMapper.selectProductOrdersDate(requestOrderDTO.getOrdUid(), requestOrderDTO.getBeginDate(), requestOrderDTO.getEndDate(), responseOrderDTO.getStartNum());
            log.info("responseOrderDTO : "+responseOrderDTO);

            responseOrderDTO.setDtoList(dtoList);
            log.info("dtoList : "+responseOrderDTO.getDtoList());
        }
        return responseOrderDTO;
    }
    public PageResponsePointDTO point(PageRequestPointDTO requestPointDTO){
        log.info("requestPointDTO.getDateType() : "+requestPointDTO.getDateType());
        PageResponsePointDTO responsePointDTO=null;
        if(requestPointDTO.getDateType() == null||requestPointDTO.getDateType().equals("")){
            log.info("uid : "+requestPointDTO.getUid());
            int total = memberPointRepository.countByUid(requestPointDTO.getUid());
            log.info("total : "+total);
            responsePointDTO = new PageResponsePointDTO(requestPointDTO, total);
            log.info("responsePointDTO.getStartNum : "+responsePointDTO.getStartNum());
            log.info("requestPointDTO.getUid() : "+requestPointDTO.getUid());
            List<MemberPointDTO> dtoList = pointMapper.selectPoints(requestPointDTO.getUid(), responsePointDTO.getStartNum());
            log.info("responsePointDTO : "+responsePointDTO);
            responsePointDTO.setDtoList(dtoList);
            log.info("dtoList : "+responsePointDTO.getDtoList());
        }else{
            requestPointDTO.getBeginDate(requestPointDTO.getDateType());

            log.info("uid : "+requestPointDTO.getUid());
            log.info("beginDate : "+requestPointDTO.getBeginDate());
            log.info("EndDate : "+requestPointDTO.getEndDate());

            int total = memberPointRepository.countByUidAndPointDateGreaterThanEqualAndPointDateLessThanEqual(requestPointDTO.getUid(), requestPointDTO.getBeginDate(), requestPointDTO.getEndDate());
            responsePointDTO = new PageResponsePointDTO(requestPointDTO, total);
            List<MemberPointDTO> dtoList = pointMapper.selectPointsDate(requestPointDTO.getUid(), requestPointDTO.getBeginDate(), requestPointDTO.getEndDate(), responsePointDTO.getStartNum());
            log.info("responsePointDTO : "+responsePointDTO);

            responsePointDTO.setDtoList(dtoList);
            log.info("dtoList : "+responsePointDTO.getDtoList());
        }
        return responsePointDTO;
    }

    public MyInfoDTO findMyInfo(String uid){
        log.info("findMyInfo uid : "+uid);
        MyInfoDTO mDTO = memberMapper.selectMyInfo(uid);
        log.info("findMyInfo : "+mDTO.toString());
        log.info("findMyInfo : "+mDTO.getPoint());
        log.info("findMyInfo : "+mDTO.getCount_b());
        log.info("findMyInfo : "+mDTO.getCount_d());
        log.info("findMyInfo : "+mDTO.getCount_c());
        return mDTO;
    }

}
