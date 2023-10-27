package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberPointDTO;
import kr.co.lotteon.dto.product.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    public List<ProductDTO> selectProductHit();
    public List<ProductDTO> selectProductScore();

    public List<ProductDTO> selectProductNew();

    public List<ProductDTO> selectProductDiscount();

    public List<ProductDTO> selectProductSold();


    public ProductDTO selectProduct(int prodNo);



}
