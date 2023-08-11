package com.mycompany.myproject.web.dto;

import com.mycompany.myproject.domain.posts.Records;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RecordsListResponseDto {

    private Long recordId;
    private String recordTitle;
    private String location;
    private LocalDateTime modifiedDate;


    public RecordsListResponseDto(Records entity) {
        this.recordId  = entity.getRecordId();
        this.recordTitle = entity.getRecordTitle();
        this. location = entity.getLocation();
        this.modifiedDate = entity.getModifiedDate();
    }

}

