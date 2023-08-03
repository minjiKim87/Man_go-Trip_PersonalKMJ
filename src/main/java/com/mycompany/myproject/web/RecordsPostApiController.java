package com.mycompany.myproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.mycompany.myproject.web.dto.RecordsSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class RecordsPostApiController {

    private final com.mycompany.myproject.service.RecordsService RecordsService;

    @PostMapping("/api/v1/Records")
    public long save(@RequestBody RecordsSaveRequestDto requestDto) {
        return RecordsService.save(requestDto);
    }

    /*여기 아래는 각각 update, delete 등등 페이지 작성을 해야된다*/
   /* @PutMapping("/api/v1/Records/{record_record_id}")
    public Long update(@PathVariable Long record_id, @RequestBody RecordsUpdateRequestDto requestDto) {
        return RecordsService.update(record_id, requestDto);
    }

    @DeleteMapping("/api/v1/Records/{record_id}")
    public Long delete(@PathVariable Long record_id) {
        RecordsService.delete(record_id);
        return record_id;
    }

    @GetMapping("/api/v1/Records/{record_id}")
    public RecordsResponseDto findByRecordId(@PathVariable Long record_id) {
        return RecordsService.findByRecordId(record_id);
    }

    @GetMapping("/api/v1/Records/list")
    public List<RecordsListResponseDto> findAll() {
        return RecordsService.findAllDesc();
    }*/
}
