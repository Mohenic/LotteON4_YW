package kr.co.lotteon.repository.product;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCate1Repository extends JpaRepository<ProductCate1Entity, Integer> {


    // ProductCate2DTO findProductIndexCateByProdCate2(ProductCate2DTO cate2DTO);
}
