package kr.co.lotteon.mapper.admin;

import kr.co.lotteon.dto.cs.CsCate3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {

    public List<CsCate3DTO> faqListType (String cate2);

}
