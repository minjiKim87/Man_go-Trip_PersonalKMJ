package com.mycompany.myproject.web;

import com.mycompany.myproject.domain.posts.RecordContent;
import com.mycompany.myproject.domain.posts.RecordContentRepository;
import com.mycompany.myproject.service.RecordContentService;
import com.mycompany.myproject.web.dto.RecordsContentSaveRequestDto;
import com.mycompany.myproject.web.dto.RecordsContentUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RecordContentApiController {

    private final RecordContentRepository recordContentRepository;
    private final RecordContentService recordContentService;

    @Autowired
    public RecordContentApiController(RecordContentRepository recordContentRepository,
                                      RecordContentService recordContentService) {
        this.recordContentRepository = recordContentRepository;
        this.recordContentService = recordContentService;
    }

    @PostMapping("/add-record-content")
    public Long createRecordContent(@RequestBody RecordsContentSaveRequestDto requestDto) {
        return recordContentService.saveContent(requestDto);
    }

    @PutMapping("/update-record-content/{recordContentId}")
    public Long updateRecordContent(@PathVariable Long recordContentId, @RequestBody RecordsContentUpdateRequestDto requestDto) {
        return recordContentService.updateRecordContent(recordContentId, requestDto);
    }

    @GetMapping("/check-record-content")
    public ResponseEntity<?> checkRecordContentExists(@RequestParam Long recordId, @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {

        Long recordContentId = recordContentService.checkRecordContentExists(recordId, date);

        if (recordContentId != null) {
            return new ResponseEntity<>(recordContentId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/fetch-record-content/{recordId}")
    public ResponseEntity<List<RecordContent>> fetchRecordContent(@PathVariable Long recordId) {
        List<RecordContent> recordContents = recordContentService.fetchRecordContent(recordId);
        return new ResponseEntity<>(recordContents, HttpStatus.OK);
    }

}
