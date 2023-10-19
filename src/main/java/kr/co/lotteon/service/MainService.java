package kr.co.lotteon.service;

import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.mapper.ProductMapper;
import kr.co.lotteon.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private ProductMapper productMapper;

    public List<ProductEntity> selectProductHtiList(){
        List<ProductEntity> entity1 = productMapper.selectProductHit().stream().map(e -> e.toEntity()).toList();
        return entity1;
    }

    public List<ProductEntity> selectProductScoreList(){
        List<ProductEntity> entity2 = productMapper.selectProductScore().stream().map(e -> e.toEntity()).toList();
        return entity2;
    }

    public List<ProductEntity> selectProductNewList(){
        List<ProductEntity> entity3 = productMapper.selectProductNew().stream().map(e -> e.toEntity()).toList();
        return entity3;
    }

    public List<ProductEntity> selectProductDiscountList(){
        List<ProductEntity> entity4 = productMapper.selectProductDiscount().stream().map(e -> e.toEntity()).toList();
        return entity4;
    }

    public List<ProductEntity> selectProductSoldList(){
        List<ProductEntity> entity5 = productMapper.selectProductSold().stream().map(e -> e.toEntity()).toList();
        return entity5;
    }


}
