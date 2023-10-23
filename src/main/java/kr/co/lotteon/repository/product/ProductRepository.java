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

    @Query("SELECT m FROM ProductEntity m WHERE m.prodCate1 =:prodCate1 AND m.prodCate2 =:prodCate2")
    public Page<ProductEntity> findProductEntitiesByProdCate1AndProdCate2(@Param("prodCate1") int prodCate1, @Param("prodCate2") int prodCate2, Pageable pageable);
}