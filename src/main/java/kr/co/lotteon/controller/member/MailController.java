package kr.co.lotteon.controller.member;

import kr.co.lotteon.dto.RequestEmailDTO;
import kr.co.lotteon.dto.ResponseEmailDTO;
import kr.co.lotteon.service.MailService;
import kr.co.lotteon.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequestMapping("/member/email")
@RestController
public class MailController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MailService mailService;


    @GetMapping("/authEmail")
    public ResponseEmailDTO checkAuthEmail(RequestEmailDTO dto) {
        log.info("들어오긴 하는데....");
            //
        int result = 0;
        int status = 0;
        log.info("requestEmailDTO의 division 종류 : "+dto.getDivision());

        if(dto.getDivision().equals("REGISTER")) {
            //회원가입 할 때 이메일 인증
            result = memberService.countEmail(dto.getEmail());//이메일 중복체크
            if(result == 0) { //가입된 이메일로 인증할 수 없음
                status  = mailService.sendMail(dto.getEmail());//이메일 발송 함수 호출
            }
        }else if(dto.getDivision().equals("FIND_ID")){
            //아이디 찾기 할 때 이메일 인증
            result = memberService.countByNameAndEmail(dto.getName(), dto.getEmail());
            if(result == 1) { //가입된 이메일로 인증
                status  = mailService.sendMail(dto.getEmail());//이메일 발송 함수 호출
            }
        }else if(dto.getDivision().equals("FIND_PASS")){
            //비밀번호 찾기 할 때 이메일 인증
            result = memberService.countByUidAndEmail(dto.getUid(), dto.getEmail());

            if(result == 1) { //가입된 이메일로 인증
                status  = mailService.sendMail(dto.getEmail());//이메일 발송 함수 호출
            }
        }else if(dto.getDivision().equals("MODIFY")){
            //회원정보 수정 할 때 이메일 인증
            result = memberService.countEmail(dto.getEmail());//이메일 중복체크
            if(result == 0) { //가입된 이메일로 인증할 수 없음
                //회원정보 수정(이메일)할 때 이메일 인증
                status  = mailService.sendMail(dto.getEmail());//이메일 발송 함수 호출

            }
        }
        ResponseEmailDTO response = new ResponseEmailDTO();
        response.setResult(result);
        response.setStatus(status);
        return response;
    }

    // 코드확인 method 설정
    @PostMapping("/confirmEmail/{code}")
    public int confirmEmail(@PathVariable("code") String code) {
        int result = mailService.confirmCodeByEmail(code);
        return result;
    }
}
