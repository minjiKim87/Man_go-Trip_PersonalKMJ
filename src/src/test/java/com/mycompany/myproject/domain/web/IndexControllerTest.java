package com.mycompany.myproject.domain.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/indexTest", String.class);

        //then
        assertThat(body).contains("index");
    }

    @Test
    public void 레코드목록_페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/view_record_list", String.class);

        //then
        assertThat(body).contains("간단 여행기록 추가");
    }
}
