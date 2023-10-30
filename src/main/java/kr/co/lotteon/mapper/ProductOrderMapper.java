package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.MemberPointDTO;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ProductOrderMapper {
    public List<ProductOrderDTO> selectProductOrders(String ordUid, int startNum);

    public List<ProductOrderDTO> selectProductOrdersDate(String ordUid, LocalDate beginDate, LocalDate endDate, int startNum);


    public int insertOrder(ProductOrderDTO prodOrder);

    ProductOrderDTO selectOrder();

    public void insertOrderItem(ProductOrderItemDTO oderItem, int ordNo);

    public void insertMPoint(MemberPointDTO mPointDto, int ordNo);

    public void updatePoint(MemberDTO memberDTO, int point);
}
