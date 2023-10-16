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
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberTermsRepository memberTermsRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

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

}
