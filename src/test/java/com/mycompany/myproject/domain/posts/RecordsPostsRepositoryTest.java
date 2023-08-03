package com.mycompany.myproject.domain.posts;

import com.mycompany.myproject.service.RecordsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycompany.myproject.Application;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class RecordsPostsRepositoryTest {

    @Autowired
    RecordsPostsRepository recordsPostsRepository;


    @After
    public void cleanup() {
        recordsPostsRepository.deleteAll();
    }

    @Test
    public void recordsPostsSaveGet() { //게시글 저장 불러오기
        String recordTitle = "Record Title_ex)전주여행";
        String location = "Record Location_ex)전주";
        Date startDate = new Date();
        Date endDate = new Date();

        recordsPostsRepository.save(Records.builder()
                .recordTitle(recordTitle)
                .location(location)
                .startDate(startDate)
                .endDate(endDate)
                .build());

        //when
        List<Records> postsList = recordsPostsRepository.findAll();

        //then
        Records records = postsList.get(0);
        /*assertThat( records.getTitle()).isEqualTo(title);
        assertThat( records.getContent()).isEqualTo(content);*/
    }
}

    /*
    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        recordsPostsRepository.save(Records.builder()
                .record_title("전주여행")
                .location("전주")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
*/