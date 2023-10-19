package kr.co.lotteon.dao;

import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CsDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    public List<CsArticleQnaDTO> selectArticleAndCate() {
        return mybatis.selectList("selectArticleAndCate");
    }

}
