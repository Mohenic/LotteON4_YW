package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductOrderMapper {
    public void insertProductOrder(ProductOrderItemDTO dto);
    public ProductOrderItemDTO selectProductOrder(String orderNo);

    public List<ProductOrderDTO> selectProductOrders(String orderUid, int startNum);

    public void updateProductOrder(ProductOrderItemDTO dto);
    public void deleteProductOrder(String orderNo);
}
