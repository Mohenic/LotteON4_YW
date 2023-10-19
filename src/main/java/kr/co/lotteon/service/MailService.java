package kr.co.lotteon.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Log4j2
@Service
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    private static final String senderEmail= "wisejohn950330@gmail.com";
    private static String code;

    public static String createNumber(){
        int number = ThreadLocalRandom.current().nextInt(100000, 1000000);
        String code = ""+number;
        log.info("code : "+code);
        return code;
    }

    public int sendMail(String toMail){
        code = createNumber();
        log.info("code : "+code);

        int status = 0;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailHelper = new MimeMessageHelper(message,"UTF-8");

        try {
            mailHelper.setFrom(senderEmail);
            mailHelper.setTo(toMail);
            mailHelper.setSubject("LotteON 이메일 인증");
            String body = "";
            body += "<h3>" + "LotteON 이메일 인증코드." + "</h3>";
            body += "<h1>" + code + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            mailHelper.setText(body,true);
            javaMailSender.send(message);
            status = 1;

        } catch (MessagingException e) {
            log.error("create Mail error : "+ e.getMessage());
            throw new RuntimeException(e);
        }

        return status;
    }

    public int confirmCodeByEmail(String confirmCode) {
        log.info("confirmCode : "+confirmCode);
        log.info("code : "+code);
        if(confirmCode.equals(code)) {
            return 1;
        }else {
            return 0;
        }
    }
}
