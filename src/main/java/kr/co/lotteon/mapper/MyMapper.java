package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.my.CouponDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {

    public List<CsArticleQnaDTO> selectQnaMy(String writer,int start);

    public int selectCountTotal();

    public List<CouponDTO> selectCoupon(String uid);


}
