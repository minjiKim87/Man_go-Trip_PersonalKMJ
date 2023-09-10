package com.mycompany.myproject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecordContentRepository extends JpaRepository<RecordContent, Long> {
    List<RecordContent> findByOrderByRecordContentIdDesc();

    Optional<RecordContent> findByRecords_RecordIdAndDate(Long recordId, Date date);

    List<RecordContent> findByRecords(Records records);

    //void deleteByRecords(Records records);
}
