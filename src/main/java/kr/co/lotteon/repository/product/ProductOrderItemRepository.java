package kr.co.lotteon.repository.product;

import kr.co.lotteon.entity.product.ProductOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProductOrderItemRepository extends JpaRepository<ProductOrderItemEntity, Integer> {
    @Query("select count(p) from ProductOrderItemEntity p join ProductOrderEntity o on p.ordNo=o.ordNo where o.ordUid = :ordUid and YEAR(o.ordDate) = YEAR(NOW())" )
    public int countByOrdUid(@Param("ordUid") String ordUid);
    @Query("select count(p) from ProductOrderItemEntity p join ProductOrderEntity o on p.ordNo=o.ordNo where o.ordUid = :ordUid and o.ordDate between :beginDate and :endDate and YEAR(o.ordDate) = YEAR(NOW())")
    int countByOrdUidAndOrdDateGreaterThanEqualAndOrdDateLessThanEqual(
            @Param("ordUid") String ordUid,
            @Param("beginDate") LocalDate beginDate,
            @Param("endDate") LocalDate endDate);
}
