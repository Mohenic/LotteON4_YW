package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.my.CouponDTO;
import kr.co.lotteon.dto.product.ProductReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {

    public List<CsArticleQnaDTO> selectQnaMy(String writer,int start);

    public int selectCountTotal();

    public List<CouponDTO> selectCoupon(String uid);

    public int selectCouponCount(String uid);

    public MemberDTO selectMyMember(String uid);

    public List<ProductReviewDTO> selectMyReview(String uid,int start);

    public int selectMyReviewCount(String uid);

    public List<ProductReviewDTO> selectMyReviewLimit5(String uid);

    public List<CsArticleQnaDTO> selectQnaMyLimit5(String uid);


}
