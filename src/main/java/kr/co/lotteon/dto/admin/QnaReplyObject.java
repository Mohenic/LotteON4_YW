package kr.co.lotteon.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaReplyObject {
        private int parent;
        private String cate1;
        private String content;
        private String writer;
        private String regip;

    public QnaReplyObject(int parent, String cate1, String content, String writer, String regip) {
        this.parent = parent;
        this.cate1 = cate1;
        this.content = content;
        this.writer = writer;
        this.regip = regip;
    }
}
