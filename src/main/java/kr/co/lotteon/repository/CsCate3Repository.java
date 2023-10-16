package kr.co.lotteon.repository;

import kr.co.lotteon.entity.cs.CsCate3Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsCate3Repository extends JpaRepository<CsCate3Entity, String> {

    public List<CsCate3Entity> findCsCate3EntitiesByCate2(String cate2);

    
}
