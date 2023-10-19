package kr.co.lotteon.entity.cs;

import jakarta.persistence.*;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lo_cs_article_notice")
public class CsArticleNoticeEntity {

    @Id
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

    @CreationTimestamp
    private LocalDateTime rdate;

    public CsArticleNoticeDTO toDTO(){
        return CsArticleNoticeDTO.builder()
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
