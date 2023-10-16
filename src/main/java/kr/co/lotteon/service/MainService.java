package kr.co.lotteon.service;

import kr.co.lotteon.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private MemberRepository memberRepository;

}
