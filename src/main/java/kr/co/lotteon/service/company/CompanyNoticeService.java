package kr.co.lotteon.service.company;

import kr.co.lotteon.dto.company.CompanyNoticeDTO;
import kr.co.lotteon.mapper.company.CompanyNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyNoticeService {

    @Autowired
    private CompanyNoticeMapper mapper;

    // list
    public List<CompanyNoticeDTO> comNoticeList (int start){
        return mapper.comNoticeList(start);
    }

    public int selectCountTotal (){
        return mapper.selectCountTotal();
    }

    // view

    public CompanyNoticeDTO comNoticeView (int no){
        return mapper.comNoticeView(no);
    }

}
