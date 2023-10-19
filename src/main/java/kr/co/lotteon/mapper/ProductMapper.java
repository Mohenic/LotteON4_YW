package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.product.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    public List<ProductDTO> selectProductHit();
    public List<ProductDTO> selectProductScore();

    public List<ProductDTO> selectProductNew();

    public List<ProductDTO> selectProductDiscount();

    public List<ProductDTO> selectProductSold();

}
