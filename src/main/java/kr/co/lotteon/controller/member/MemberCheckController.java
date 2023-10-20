package kr.co.lotteon.controller.member;

import kr.co.lotteon.dto.RequestEmailDTO;
import kr.co.lotteon.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RequestMapping("/member/check")
@RestController
public class MemberCheckController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/uid/{uid}")
    public int checkUid(@PathVariable("uid") String uid){
        return memberService.countUid(uid);
    }

    @GetMapping("/hp/{hp}")
    public int checkHp(@PathVariable("hp") String hp){
        log.info("hp : "+hp);
        log.info("hp : "+memberService.countHp(hp));
        return memberService.countHp(hp);
    }
    @GetMapping("/managerHp/{managerHp}")
    public int checkManagerHp(@PathVariable("managerHp") String managerHp){
        int result = memberService.countManagerHp(managerHp);
        return result;
    }

}
