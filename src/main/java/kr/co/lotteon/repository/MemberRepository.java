package kr.co.lotteon.repository;

import kr.co.lotteon.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    int countByUid(String uid);
    int countByEmail(String email);
    int countByHp(String hp);
    int countByManagerHp(String managerHp);
    int countByNameAndEmail(String name, String email);
    int countByUidAndEmail(String uid, String email);
}
