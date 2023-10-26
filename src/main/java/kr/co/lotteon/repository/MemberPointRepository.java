package kr.co.lotteon.repository;

import kr.co.lotteon.entity.MemberPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MemberPointRepository extends JpaRepository<MemberPointEntity, Integer> {
    @Query("select count(p) from MemberPointEntity p where p.uid = :uid and YEAR(p.pointDate) = YEAR(NOW())" )
    public int countByUid(@Param("uid") String uid);
    @Query("select count(p) from MemberPointEntity p where p.uid = :uid and p.pointDate between :beginDate and :endDate and YEAR(p.pointDate) = YEAR(NOW())")
    int countByUidAndPointDateGreaterThanEqualAndPointDateLessThanEqual(
            @Param("uid") String uid,
            @Param("beginDate") LocalDate beginDate,
            @Param("endDate") LocalDate endDate);
    
}
