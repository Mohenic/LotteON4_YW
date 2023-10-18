package kr.co.lotteon.service;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.MemberTermsDTO;
import kr.co.lotteon.entity.MemberEntity;
import kr.co.lotteon.repository.MemberRepository;
import kr.co.lotteon.repository.MemberTermsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberTermsRepository memberTermsRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    String generatedCode;

    public MemberTermsDTO selectTerms() {
        log.info("selectTerms : "+memberTermsRepository.findById(1).get().toDTO());
        return memberTermsRepository.findById(1).get().toDTO();
    }
    public void save(MemberDTO dto){
        // 비밀번호 암호화

        dto.setPass1(passwordEncoder.encode(dto.getPass1()));
        // DTO를 Entity로 변환
        MemberEntity entity = dto.toEntity();
        // DB insert
        memberRepository.save(entity);
    }

    public int countUid(String uid){
        return memberRepository.countByUid(uid);
    }
    public int countEmail(String email){
        return memberRepository.countByEmail(email);
    }
    public int countHp(String hp){
        return memberRepository.countByHp(hp);
    }
    public int countManagerHp(String managerHp){
        return memberRepository.countByManagerHp(managerHp);
    }
    public int countByNameAndEmail(String name, String email){
        return memberRepository.countByNameAndEmail(name, email);
    }
    public int countByUidAndEmail(String uid, String email){
        return memberRepository.countByUidAndEmail(uid, email);
    }

}
