package com.mycompany.myproject.web.dto;//여기 안에 Records와 RecordContent Save관련된걸 같이

import com.mycompany.myproject.domain.posts.Records;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class RecordsSaveRequestDto {

    private Cost cost_id;
    private String record_title;



    private String location;
    private Date start_date;
    private Date end_date;
    private List<RecordsContentSaveRequestDto> recordContents;

    @Builder
    public RecordsSaveRequestDto(String record_title, String location){

        this.record_title = record_title;
        this.location = location;

    }

    public Records toEntity(){
        //DTO 객체를 엔티티 객체로 변환
        return Records.builder()
                .recordTitle(record_title)
                .location(location)
                .build();
    }

}

