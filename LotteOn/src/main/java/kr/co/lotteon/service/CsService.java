package kr.co.lotteon.service;

import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.repository.CsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsService {

    private final CsRepository csrepo;
    public List<CsCate2Entity> selectCate2(String cate2){

        return null; //csrepo.findById(cate2);

    }


}
