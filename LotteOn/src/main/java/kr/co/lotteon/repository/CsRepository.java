package kr.co.lotteon.repository;

import kr.co.lotteon.entity.cs.CsArticleEntity;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsRepository extends JpaRepository<CsArticleEntity, Integer> {

    public Page<CsArticleEntity> findCsArticleEntitiesByCate1AndUseynAndParent(String cate1, String useyn, int parent, Pageable pageable);
    public Page<CsArticleEntity> findCsArticleEntitiesByCate1AndCate2AndUseynAndParent(String cate1,String cate2,String useyn,int parent,Pageable pageable);

}
