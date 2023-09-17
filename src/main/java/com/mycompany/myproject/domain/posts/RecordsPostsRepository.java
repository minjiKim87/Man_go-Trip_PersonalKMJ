package com.mycompany.myproject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordsPostsRepository extends JpaRepository<Records, Long> {

    List<Records> findByOrderByRecordIdDesc();



}