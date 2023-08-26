package com.mycompany.myproject.service;

import com.mycompany.myproject.domain.posts.RecordContent;
import com.mycompany.myproject.domain.posts.RecordContentRepository;
import com.mycompany.myproject.domain.posts.Records;
import com.mycompany.myproject.domain.posts.RecordsPostsRepository;
import com.mycompany.myproject.web.dto.RecordsContentSaveRequestDto;
import com.mycompany.myproject.web.dto.RecordsContentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecordContentService {

    private final RecordContentRepository recordContentRepository;
    private final RecordsPostsRepository recordsPostsRepository; // 추가

    @Transactional
    public Long saveContent(RecordsContentSaveRequestDto requestDto) {
        Records record = recordsPostsRepository.findById(requestDto.getRecordId())
                .orElseThrow(() -> new IllegalArgumentException("해당 레코드가 없습니다. id=" + requestDto.getRecordId()));
        RecordContent recordContent = requestDto.toEntity(record);
        return recordContentRepository.save(recordContent).getRecordContentId();
    }

    @Transactional(readOnly = true)
    public List<RecordContent> fetchAllContents() {
        return recordContentRepository.findAll();
    }

    @Transactional
    public Long updateContent(Long recordContentId, RecordsContentSaveRequestDto requestDto) {
        RecordContent content = recordContentRepository.findById(recordContentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 내용이 없습니다. id=" + recordContentId));
        Records record = recordsPostsRepository.findById(requestDto.getRecordId())
                .orElseThrow(() -> new IllegalArgumentException("해당 레코드가 없습니다. id=" + requestDto.getRecordId()));
        content.update(record, requestDto.getContent(), requestDto.getHashtag(), requestDto.getDate());
        return recordContentId;
    }

    @Transactional
    public void deleteContent(Long recordContentId) {
        RecordContent content = recordContentRepository.findById(recordContentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 내용이 없습니다. id=" + recordContentId));
        recordContentRepository.delete(content);
    }

    @Transactional
    public Long updateRecordContent(Long recordContentId, RecordsContentUpdateRequestDto requestDto) {
        RecordContent recordContent = recordContentRepository.findById(recordContentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 내용이 없습니다. id=" + recordContentId));

        Records records = recordsPostsRepository.findById(requestDto.getRecordId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + requestDto.getRecordId()));

        recordContent.update(requestDto.getContent(), requestDto.getHashtag());

        return recordContentId;
    }

    @Transactional(readOnly = true)
    public Long checkRecordContentExists(Long recordId, Date date) {
        Optional<RecordContent> recordContentOpt = recordContentRepository.findByRecords_RecordIdAndDate(recordId, date);

        return recordContentOpt.map(RecordContent::getRecordContentId).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<RecordContent> fetchRecordContent(Long recordId) {
        Records records = recordsPostsRepository.findById(recordId)
                .orElseThrow(() -> new IllegalArgumentException("해당 레코드가 없습니다. id=" + recordId));
        return recordContentRepository.findByRecords(records);
    }

}
