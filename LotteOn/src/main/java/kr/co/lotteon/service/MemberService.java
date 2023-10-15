package kr.co.lotteon.service;

import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.MemberTermsDTO;
import kr.co.lotteon.entity.MemberEntity;
import kr.co.lotteon.repository.MemberRepository;
import kr.co.lotteon.repository.MemberTermsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberTermsRepository memberTermsRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper; //��로 Bean 설정을 해주어��함
    private final PasswordEncoder passwordEncoder;

    public List<MemberTermsDTO> selectTerms() {
        List<MemberTermsDTO> terms = memberTermsRepository.findAll()
                                                        .stream()
                                                        .map(entity -> modelMapper.map(entity, MemberTermsDTO.class))
                                                        .toList();
        return terms;
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
