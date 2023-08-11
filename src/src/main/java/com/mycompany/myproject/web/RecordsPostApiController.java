package com.mycompany.myproject.web;

import com.mycompany.myproject.domain.posts.Records;
import com.mycompany.myproject.service.RecordsService;
import com.mycompany.myproject.web.dto.RecordsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordsPostApiController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/fetch-records")
    public List<Records> fetchAllRecords() {
        return recordsService.fetchAllRecords();
    }

    @PostMapping("/add-record")
    public Long createRecord(@RequestBody RecordsSaveRequestDto requestDto) {
        return recordsService.save(requestDto);
    }


    @PutMapping("/update-record/{id}")
    public Long updateRecord(@PathVariable Long id, @RequestBody RecordsSaveRequestDto requestDto) {
        return recordsService.update(id, requestDto);
    }

    @DeleteMapping("/delete-record/{id}")
    public void deleteRecord(@PathVariable Long id) {
        recordsService.delete(id);
    }


}
