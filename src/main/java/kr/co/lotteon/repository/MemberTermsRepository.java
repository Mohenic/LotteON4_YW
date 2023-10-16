package kr.co.lotteon.repository;

import kr.co.lotteon.entity.MemberTermsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberTermsRepository extends JpaRepository<MemberTermsEntity, Integer>{
    
}
