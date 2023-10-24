package kr.co.lotteon.repository.product;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCate1Repository extends JpaRepository<ProductCate1Entity, Integer> {

    public List<ProductCate1Entity> findByCate1(Integer cate1);
}
