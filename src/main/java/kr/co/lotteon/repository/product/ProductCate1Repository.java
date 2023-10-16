package kr.co.lotteon.repository.product;

import kr.co.lotteon.entity.product.ProductCate1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCate1Repository extends JpaRepository<ProductCate1Entity, Integer> {
    
}
