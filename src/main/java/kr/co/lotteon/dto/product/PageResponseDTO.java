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
    private int prodCate1;
    private int prodCate2;
    private int prodNo;
    private String useyn="Y";
    private String sort;
    private String orderBy;

    private int start;
    private int end;
    private boolean prev;
    private boolean next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ProductDTO> dtoList, int total){
        //  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ProductDTO> dtoList, List<CsArticleNoticeDTO> noticeList, int total){  노티스 디티오 추가 처럼 dto데이터를 매개 변수로 설정 해서 여러 타입의 데이터를 한 곳에서 받아 모듈화 하는 것 이 가능;   노티스 테스트  
        
        
        
        this.prodCate1= pageRequestDTO.getProdCate1();
        this.prodCate2= pageRequestDTO.getProdCate2();
        this.pg=pageRequestDTO.getPg();
        this.size= pageRequestDTO.getSize();
        this.total =total;
        this.dtoList=dtoList;
        //this.noticeList=noticeList; 노티스 테스트 
        
        this.end= (int) (Math.ceil(this.pg/10.0))*10;
        this.start=this.end-9;
        int last= (int)(Math.ceil(total/(double)size));

        this.end= end > last ? last : end;
        this.prev = this.start>1;
        this.next=total > this.end* this.size;
        this.sort = pageRequestDTO.getSort();
        this.orderBy = pageRequestDTO.getOrderBy();



    }



}
