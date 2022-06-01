package com.guide.blog.board;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * writeId - 작성자 id <br>
 * title - 제목 <br>
 * content - 내용 <br>
 */
@Data
public class NoticeBoard {
    @NotNull long writeId;
    @NotBlank String title;
    @NotBlank String content;
}
