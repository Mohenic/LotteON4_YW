package kr.co.lotteon.service.admin.cs;

import kr.co.lotteon.dto.cs.CsCate3DTO;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.mapper.admin.FaqMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminFaqService {

    private final FaqMapper mapper;

    public List<CsCate3Entity> faqListType(String cate2){

        log.info("1234...");

        log.info("mapper.FaqListType(cate2) : " + mapper.faqListType(cate2));

        return mapper.faqListType(cate2).stream().map(e -> e.toEntity()).toList();
    }

}
