package kr.co.lotteon.repository.product;

import kr.co.lotteon.dto.product.ProductCate2DTO;
import kr.co.lotteon.entity.product.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public Page<ProductEntity> findProductEntitiesByprodCate1(int cate1, Pageable pageable);
    


    public Page<ProductEntity> findByUseyn(String useyn, Pageable pageable);


}