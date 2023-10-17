package kr.co.lotteon.repository.product;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.dto.product.ProductCate2DTO;
import kr.co.lotteon.entity.product.ProductCate2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCate2Repository extends JpaRepository<ProductCate2Entity, Integer>{
    List<ProductCate2Entity> findAllByCate1(int cate1);
}
