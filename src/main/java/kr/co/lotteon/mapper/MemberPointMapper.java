package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberPointDTO;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MemberPointMapper {
    public List<MemberPointDTO> selectPoints(String uid, int startNum);

    public List<MemberPointDTO> selectPointsDate(String uid, LocalDate beginDate, LocalDate endDate, int startNum);


}
