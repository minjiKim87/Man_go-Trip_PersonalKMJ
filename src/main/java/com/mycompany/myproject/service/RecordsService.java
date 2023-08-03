package com.mycompany.myproject.service;

import com.mycompany.myproject.domain.posts.RecordsPostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mycompany.myproject.web.dto.RecordsSaveRequestDto;

import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service

public class RecordsService {
    private final RecordsPostsRepository recordsPostsRepository;

    @Transactional
    public long save(RecordsSaveRequestDto requestDto) {
        return recordsPostsRepository.save(requestDto.toEntity()).getRecordId();
    }

   /* @Transactional
    public int update(int record_id, PostsUpdateRequestDto requestDto) {
        Posts posts = recordsPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return record_id;
    }

    @Transactional
    public void delete (int record_id) {
        Posts records = recordsPostsRepository.findById(record_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자(기록이?)가 없습니다. id=" + record_id));

        recordsPostsRepository.delete(records);
    }

    @Transactional(readOnly = true)
    public RecordsResponseDto findByRecordId(int record_id) {
        Records entity = recordsRepository.findByRecordId(record_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + record_id));

        return new RecordsResponseDto(entity);
    }
*/
    /*Post 리스트 받는것*/
   /* @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }*/
}
