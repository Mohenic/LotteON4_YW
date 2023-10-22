package kr.co.lotteon.repository.product;

import kr.co.lotteon.entity.product.ProductEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public Page<ProductEntity> findProductEntitiesByprodCate1(int cate1, Pageable pageable);

    // admin list part
    public Page<ProductEntity> findByUseyn(String useyn, Pageable pageable);
    public Page<ProductEntity> findByProdNameLike(String prodName, Pageable pageable);
    public Page<ProductEntity> findByProdNoLike(int prodNo, Pageable pageable);
    public Page<ProductEntity> findByCompanyLike(String company, Pageable pageable);
    public Page<ProductEntity> findBySellerLike(String seller, Pageable pageable);

    // admin list delete
    public List<ProductEntity> findByProdNo(int prodNo);

    @Query("SELECT p FROM ProductEntity p WHERE p.prodCate1 = :cate1 AND p.prodCate2 = :cate2")
    public Page<ProductEntity> findProductEntitiesByProdCate1AndProdCate2(@Param("cate1") int cate1, @Param("cate2") int cate2, Pageable pageable);
}