package kr.co.lotteon.dto.cs;

import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CsArticleFaqDTO {


    private int no;
    private int parent;
    private int comment;
    private String cate1;
    private String cate2;
    private String type;
    private String title;
    private String content;
    private String writer;
    private int hit;
    private String useyn;
    private String regip;
    private LocalDateTime rdate;

    public CsArticleFaqEntity toEntity(){
        return CsArticleFaqEntity.builder()
                .no(no)
                .parent(parent)
                .comment(comment)
                .cate1(cate1)
                .cate2(cate2)
                .type(type)
                .title(title)
                .content(content)
                .writer(writer)
                .hit(hit)
                .useyn(useyn)
                .regip(regip)
                .rdate(rdate)
                .build();
    }

}
