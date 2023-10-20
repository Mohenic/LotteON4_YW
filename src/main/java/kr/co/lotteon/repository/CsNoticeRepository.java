package kr.co.lotteon.repository;

import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsNoticeRepository extends JpaRepository<CsArticleNoticeEntity, Integer> {

    public Page<CsArticleNoticeEntity> findCsArticleNoticeEntitiesByCate1AndUseynAndParent(String cate1, String useyn, int parent, Pageable pageable);
    public Page<CsArticleNoticeEntity> findCsArticleNoticeEntitieByCate1AndCate2AndUseynAndParent(String cate1, String cate2, String useyn, int parent, Pageable pageable);

    public CsArticleNoticeEntity findCsArticleNoticeEntitiesByNo(int no);
    public List<CsArticleNoticeEntity> findTop5ByOrderByNoDesc();


    // admin part

    public List<CsArticleNoticeEntity> findByNo(int no);
}
