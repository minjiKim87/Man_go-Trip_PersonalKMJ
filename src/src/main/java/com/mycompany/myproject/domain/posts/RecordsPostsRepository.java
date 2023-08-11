package com.mycompany.myproject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordsPostsRepository extends JpaRepository<Records, Long> {

   // @Query("")//SELECT p FROM Posts p ORDER BY p.id DESC
    //어떤 쿼리가 들어가야할까
    List<Records> findByOrderByRecordIdDesc();



}