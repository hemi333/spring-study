package com.example.spring_prepare.dto;

import com.example.spring_prepare.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }
}
