package kr.co.lotteon.mapper.company;

import kr.co.lotteon.dto.company.CompanyNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyNoticeMapper {

    // list
    public List<CompanyNoticeDTO> comNoticeList (int start);
    public int selectCountTotal();

    // view

    public CompanyNoticeDTO comNoticeView (int no);
}
