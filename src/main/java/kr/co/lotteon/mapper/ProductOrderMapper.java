package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProductOrderMapper {
    public List<ProductOrderDTO> selectProductOrders(String ordUid, int startNum);

    public List<ProductOrderDTO> selectProductOrdersDate(String ordUid, LocalDateTime beginDate, LocalDateTime endDate, int startNum);
    public List<ProductOrderDTO> selectProductOrdersDate2(String ordUid, int start, int startNum);

}
