package com.mycompany.myproject.web;

import com.mycompany.myproject.domain.TestEntity;
import com.mycompany.myproject.domain.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/insert")
    public TestEntity insertData() {
        TestEntity entity = new TestEntity();
        entity.setName("SampleName");
        return testRepository.save(entity);
    }

    @GetMapping("/all")
    public Iterable<TestEntity> getAllData() {
        return testRepository.findAll();
    }

    @GetMapping("/get")
    public ResponseEntity<?> getData() {
        try {
            List<TestEntity> dataList = (List<TestEntity>) testRepository.findAll();
            return new ResponseEntity<>(dataList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("데이터 가져오기 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
