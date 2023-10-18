package kr.co.lotteon.repository;

import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsFaqRepository extends JpaRepository<CsArticleFaqEntity, Integer> {

    //public Page<CsArticleNoticeEntity> findCsArticleFaqEntitiesByCate1AndUseynAndParent(String cate1, String useyn, int parent, Pageable pageable);
    //public Page<CsArticleNoticeEntity> findCsArticleEntitiesByCate1AndCate2AndUseynAndParent(String cate1, String cate2, String useyn, int parent, Pageable pageable);


   // public List<CsArticleFaqEntity> findCsArticleFaqEntitiesByCate1AndCate2AndUseynAndParent(String cate1,String cate2, String useyn, int parent);

    public List<CsArticleFaqEntity> findByCate1AndCate2AndUseynAndParent(String cate1,String cate2, String useyn, int parent);
    public CsArticleFaqEntity findCsArticleFaqEntitiesByNo(int no);

}
