package com.mycompany.myproject.web;

import com.mycompany.myproject.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/fetch-data")
    public List<Map<String, Object>> fetchData() {
        return databaseService.fetchAllTestData();
    }
}
