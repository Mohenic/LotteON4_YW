package kr.co.lotteon.repository.product;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.entity.product.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public Page<ProductEntity> findProductEntityByProdNoAndProdCate1(int prodNo, String cate1, Pageable pageable);
    
    
    public Page<ProductEntity> findProductEntityByProdNoAndProdCate1AndProdCate2(int prodNo, String cate1, String cate2, Pageable pageable);
    
}