package kr.co.lotteon.dto.my;

import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.util.Pager;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class PageResponseOrderDTO {
    Pager pager = new Pager();

    //private List<CsArticleNoticeDTO> noticeList;   노티스 테스트
    private int currentPage;
    private int total;
    private int lastPageNum;
    private int pageGroupStart;
    private int pageGroupEnd;
    private List<ProductOrderDTO> dtoList;
    // ordUid, ordNo, product.seller, product.Name

    private int pageStartNum;
    private int startNum;

    private String dateType;
    private int month;

    @Builder
    public PageResponseOrderDTO (PageRequestOrderDTO pageRequestOrderDTO, int total){
        //  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ProductDTO> dtoList, List<CsArticleNoticeDTO> noticeList, int total){  노티스 디티오 추가 처럼 dto데이터를 매개 변수로 설정 해서 여러 타입의 데이터를 한 곳에서 받아 모듈화 하는 것 이 가능;   노티스 테스트

        this.currentPage = pager.getCurrentPage(pageRequestOrderDTO.getPg());
        this.total = total;
        this.lastPageNum = pager.getLastPageNum(total);
        this.pageGroupStart = pager.getPageGroupNum(currentPage, lastPageNum)[0];
        this.pageGroupEnd = pager.getPageGroupNum(currentPage, lastPageNum)[1];
        this.pageStartNum = pager.getPageStartNum(total, currentPage);
        this.startNum = pager.getStartNum(currentPage);
        this.dateType = pageRequestOrderDTO.getDateType();
        this.month = LocalDateTime.now().getMonthValue();
    }

}
