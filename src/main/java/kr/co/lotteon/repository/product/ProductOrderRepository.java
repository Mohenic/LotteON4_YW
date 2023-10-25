package kr.co.lotteon.repository.product;

import kr.co.lotteon.entity.product.ProductOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Integer> {

    int countByOrdUid(String ordUid);

    @Query("SELECT COUNT(*) FROM ProductOrderEntity o " +
            "WHERE o.ordUid =:ordUid AND " +
            "o.ordDate >= :beginDate AND o.ordDate <= :endDate")
    int countByOrdUidAndDate(
            @Param("ordUid") String ordUid,
            @Param("beginDate") LocalDateTime beginDate,
            @Param("endDate") LocalDateTime endDate);
}
