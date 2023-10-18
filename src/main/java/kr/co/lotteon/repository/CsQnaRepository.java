package kr.co.lotteon.repository;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsQnaRepository extends JpaRepository<CsArticleQnaEntity, Integer> {

    public Page<CsArticleQnaEntity> findCsArticleQnaEntitiesByCate1AndUseynAndParent(String cate1, String useyn, int parent, Pageable pageable);
    public Page<CsArticleQnaEntity> findCsArticleQnaEntitiesByCate1AndCate2AndUseynAndParent(String cate1, String cate2, String useyn, int parent, Pageable pageable);

    public CsArticleQnaEntity findCsArticleQnaEntitiesByNo(int no);

    public List<CsArticleQnaEntity> findTop5ByOrderByNo();

}
