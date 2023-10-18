package kr.co.lotteon.repository;

import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsCate2Repository extends JpaRepository<CsCate2Entity, String> {

    
}
