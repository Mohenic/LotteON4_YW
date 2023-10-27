package kr.co.lotteon.mapper;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.my.CouponDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import kr.co.lotteon.dto.product.ProductReviewDTO;
import kr.co.lotteon.entity.product.ProductEntity;
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

    public List<ProductOrderItemDTO> selectProductMyHomeLimit5(String uid);

    public ProductOrderDTO selectOrderStatus(String uid, int no);

    public int selectReviewstatus(int ordno,int prodno,String uid);

    public ProductDTO selectProduct (int prodno);

    public void writeReview(int prodNo, String content, int rating ,String uid, String regip, String rdate);

    public void insertPoint(int no, String uid, int point, String rdate, String descript);

    public void updateOrderStatus(int ordno, String uid);

    public MemberDTO selectSeller(String seller);

    public ProductOrderItemDTO selectOrderItem(int itemNo);

}
