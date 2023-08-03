package com.mycompany.myproject.web.dto;

import com.mycompany.myproject.domain.posts.RecordContent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordsContentSaveRequestDto {

    private Integer date; // 우리 스키마에 int라 되어있음. 여행일자들 date로 하는거아님? 뭐더라
    private String content;
    private String hashtag;

    public RecordContent toEntity(){
        return RecordContent.builder()
                .date(date)
                .content(content)
                .hashtag(hashtag)
                .build();
    }


}

