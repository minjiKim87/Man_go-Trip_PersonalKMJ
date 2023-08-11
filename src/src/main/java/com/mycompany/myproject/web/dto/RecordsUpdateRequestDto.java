package com.mycompany.myproject.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public RecordsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
