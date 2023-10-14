package kr.co.lotteon.dto.cs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@Data

public class PageResponseDTO {


    private List<CsArticleDTO> dtoList;
    private int pg;
    private int size;
    private int total;
    private String cate1;
    private String cate2;
    private String useyn="Y";

    private int start, end;
    private boolean prev,next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<CsArticleDTO> dtoList,int total){
        this.cate1= pageRequestDTO.getCate1();
        this.cate2= pageRequestDTO.getCate2();
        this.pg=pageRequestDTO.getPg();
        this.size= pageRequestDTO.getSize();
        this.total =total;
        this.dtoList=dtoList;

        this.end= (int) (Math.ceil(this.pg/10.0))*10;
        this.start=this.end-9;
        int last= (int)(Math.ceil(total/(double)size));

        this.end= end > last ? last:end;
        this.prev = this.start>1;
        this.next=total > this.end* this.size;

    }


}
