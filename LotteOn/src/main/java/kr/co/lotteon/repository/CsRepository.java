package kr.co.lotteon.repository;

import kr.co.lotteon.entity.cs.CsCate2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsRepository extends JpaRepository<CsCate2Entity, String> {



}
