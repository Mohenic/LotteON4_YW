package kr.co.lotteon.dto.product;

import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data

public class PageResponseDTO {


    private List<ProductDTO> dtoList;
    //private List<CsArticleNoticeDTO> noticeList;   노티스 테스트 
    private int pg;
    private int size;
    private int total;
    private String cate1;
    private String cate2;
    private String useyn="Y";

    private int start, end;
    private boolean prev,next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ProductDTO> dtoList, List<CsArticleNoticeDTO> noticeList, int total){
        //  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ProductDTO> dtoList, List<CsArticleNoticeDTO> noticeList, int total){  노티스 디티오 추가 처럼 dto데이터를 매개 변수로 설정 해서 여러 타입의 데이터를 한 곳에서 받아 모듈화 하는 것 이 가능;   노티스 테스트  
        
        
        
        this.cate1= pageRequestDTO.getCate1();
        this.cate2= pageRequestDTO.getCate2();
        this.pg=pageRequestDTO.getPg();
        this.size= pageRequestDTO.getSize();
        this.total =total;
        this.dtoList=dtoList;
        //this.noticeList=noticeList; 노티스 테스트 
        
        this.end= (int) (Math.ceil(this.pg/10.0))*10;
        this.start=this.end-9;
        int last= (int)(Math.ceil(total/(double)size));

        this.end= end > last ? last:end;
        this.prev = this.start>1;
        this.next=total > this.end* this.size;

    }


}
