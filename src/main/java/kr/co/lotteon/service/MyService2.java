package kr.co.lotteon.service;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;

import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;

import kr.co.lotteon.dto.product.ProductReviewDTO;
import kr.co.lotteon.entity.MemberEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.my.CouponEntity;

import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.entity.product.ProductReviewEntity;

import kr.co.lotteon.mapper.MyMapper;
import kr.co.lotteon.mapper.ProductOrderMapper;
import kr.co.lotteon.repository.product.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MyService2 {

    private final ProductOrderMapper mapper;
    private final ProductOrderRepository productOrderRepository;
    private final MyMapper mapper2;

    public List<CsArticleQnaEntity> selectQnaMy(String writer,int start){
       return mapper2.selectQnaMy(writer,start).stream().map(e -> e.toEntity()).toList();
    }

    public int selectCountQna(){
        return mapper2.selectCountTotal();
    }

    public List<CouponEntity> selectCoupon(String uid){
        return mapper2.selectCoupon(uid).stream().map(e -> e.toEntity()).toList();
    }

    public MemberEntity selectMyMember(String uid){
        return mapper2.selectMyMember(uid).toEntity();
    }

    public List<ProductReviewDTO> selectMyReview(String uid ,int start){
        return mapper2.selectMyReview(uid,start);
    }

    public int selectMyReviewCount(String uid){
        return mapper2.selectMyReviewCount(uid);
    }

    public List<ProductReviewDTO> selectMyReviewLimit5(String uid){
        return mapper2.selectMyReviewLimit5(uid);
    }

    public List<CsArticleQnaDTO> selectQnaMyLimit5(String uid) {
        return mapper2.selectQnaMyLimit5(uid);
    }

    public List<ProductOrderItemDTO> selectProductMyHomeLimit5(String uid){
        return mapper2.selectProductMyHomeLimit5(uid);
    }

    public ProductOrderDTO selectOrderStatus (String uid, int no){
        return mapper2.selectOrderStatus(uid,no);
    }

    public int selectReviewstatus(int ordno,int prodno,String uid){
        return mapper2.selectReviewstatus(ordno,prodno,uid);
    }

    public ProductDTO selectProduct(int prodno){
        return mapper2.selectProduct(prodno);
    }

    public void writeReview(int prodNo, String content, int rating ,String uid, String regip, String rdate) {
         mapper2.writeReview(prodNo,content,rating,uid,regip,rdate);
    }

    public void insertPoint(int no, String uid, int point, String rdate, String descript) {
        mapper2.insertPoint(no,uid,point,rdate,descript);
    }

    public void updateOrderStatus(int ordno, String uid){
        mapper2.updateOrderStatus(ordno,uid);
    }

    public MemberDTO selectSeller(String seller){
       return mapper2.selectSeller(seller);
    }

    public ProductOrderItemDTO selectOrderItem(int itemNo){
        return mapper2.selectOrderItem(itemNo);
    }

}
