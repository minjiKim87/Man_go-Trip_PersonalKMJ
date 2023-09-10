# 0909 부트스트랩/mustache/delete

<aside>
💡

기존 js 포함한 html 파일 → js분리하고, mustache파일로 바꾸고, 부트스트랩 적용함(헤더푸터 등등만)

</aside>

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/9c09c85e-e971-4ce5-bed9-b8c661f96296.png" alt="Untitled" width="50%">

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/44aab974-ff46-4c77-9f29-1e0f81b1e94f.png" alt="Untitled 1" width="50%">

# 1. 부트스트랩

1. 다운

[다운로드](https://getbootstrap.kr/docs/5.3/getting-started/download/)

1. 파일 헤더에 추가

1. `npm install bootstrap@5.3.1`

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/858b8a2e-3ff8-47ad-b94e-bf9e0b533ad7.png" alt="Untitled 2" width="50%">

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/462e8984-9688-4b96-ae04-92a9c57def2d.png" alt="Untitled 3" width="50%">

# 2. mustache

## mustache 파일 사용 정리

[[Spring Boot] Chap 4.Mustache로 화면 구성하기](https://doorisopen.github.io/spring/2020/03/03/spring-freelec-springboot-chap4.html)

테스트 통과 & 링크 접속시 보임

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/50150d9e-34fd-41ca-b123-4c971a08b4cb.png" alt="Untitled 4" width="50%">


1. build.gradle 파일에 `implementation('org.springframework.boot:spring-boot-starter-mustache')`
2. 테스트 코드 구현(test/…/web아래)

```java
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
        assertThat(body).contains("index"); // 확인할 mustache파일에 있을 문자열
    }
}
```

1. IndexController(java/…/web)

```java
package com.mycompany.myproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/indexTest")
    public String index(){
        return "indexTest";
    }
}
```

1. 머스태치 파일들

<aside>
💡 경로 주의!!!! 자동으로 해주니까 무조건 **`src/main/resources/templates`** 폴더 아래

</aside>

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/4a34cb16-5a7e-453e-96e3-d31494a4ff26.png" alt="Untitled 5" width="50%">

- 헤더

```java
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>learn-bootstrap</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
```

- 푸터

```java
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!--필요한 js파일은 각 파일에 따로 추가-->
<!--아래는 임시로 넣어둠. 전체 컨트롤에 필요한 js파일을 footer에 넣기-->
<script src="../js/record-functions.js"></script>

</body>
</html>
```

- 본파일(indexTest)

```java
{{>layout/header}}
<h1>index 페이지</h1>
<button class="btn btn-primary">확인</button>
<button class="btn btn-danger">취소</button>
{{> layout/footer }}
```

1. Security해제

<aside>
💡 해제 안했더니 테스트에서 자동으로 계속 로그인페이지로 가니까 통과 안되고, 어플리케이션 실행 후 링크접속했을때 안되더라

</aside>

`WebSecurityConfig.java(java/com…/config)`

기존에 모든 요청에 대해 인증받고 로그인하랬는데

그걸 이렇게 바꿈. 나중에 아마 로그인기능할때 더 생각해봐야할듯

→ 테스트에서도 통과(mustache가 작동한다)

```java
package com.mycompany.myproject.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll();
                .anyRequest().permitAll() // 모든 요청에 대해 접근을 허용
                .and()
                .formLogin().disable() // 로그인 과정을 비활성화
                .httpBasic().disable(); // 기본 인증도 비활성화
    }
}
```

# 3. 기능 문제

## 수정이 안됨

mustache로 바꾸면서 수정이 잘 안됨

DB에 반영이 안되는 문제

잘 안되서 delete도 안되길래 해결하자 →

## delete 안되는 문제

1. mustache문제는 아니고, cascade 문제
2. 외래키 참조문제로 record_content가 있는 record를 지우려면 에러가 뜨는 상황이다(전에 처리를 안했음). 
3. record_content가 없는 record는 삭제가 되었는데, 하여튼 고치다보니까 이것도 잘 안되는중

당장의 오류문구는

<aside>
💡 There was an unexpected error (type=Method Not Allowed, status=405).
Request method 'GET' not supported

</aside>

네트워크 창에서 보면 url/id 는 잘 넘겨주는데 
url이나 매핑도 잘 다 해놓은거같고 get을 안쓰는것 같은데 계속 get을 쓴다.
코드 검토 시 get을 쓰는 부분은 없어보이는데, 아마 관련 부분에서 구현을 잘못한것 같다.


<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/0872c341-7754-4053-a8d1-aae0cff02a3f.png" alt="Untitled 6" width="50%">

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/b6eabcc8-bdfb-462a-b954-e647e85feca4.png" alt="Untitled 7" width="50%">

## 성공!

흐름

1. 리스트에서 record를 삭제하고 싶음 → cascade로 record_content도 지워줘야함

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/16e67717-4703-44ba-894b-7106bb71acc7.png" alt="Untitled 8" width="50%">

1. js 파일에서 record-content 함수를 만들어두고, 버튼 눌렀을때 먼저 recordcontent삭제 하고 record 삭제하도록 함
    
    ```java
    window.deleteRecordContent = function(recordId) {
                return new Promise((resolve, reject) => {
                    $.ajax({
                        url: "/delete-record-content/" + recordId,
                        type: 'DELETE',
                        success: function(response) {
                            resolve(response);
                        },
                        error: function(response) {
                            reject(response);
                        }
                    });
                });
            }
    
            window.deleteRecord = function(recordId) {
                if (recordId === undefined || recordId === null || isNaN(recordId)) {
                    alert("유효하지 않은 레코드 ID입니다.");
                    return;
                }
    
                if (confirm("정말로 삭제하시겠습니까?")) {
                    // 먼저 RecordContent 삭제
                    deleteRecordContent(recordId).then(() => {
                        // RecordContent 삭제 후 Record 삭제
                        $.ajax({
                            url: "/delete-record/" + recordId,
                            type: 'DELETE',
                            success: function(response) {
                                location.reload();
                            },
                            error: function(response) {
                                alert('Error deleting record.');
                            }
                        });
                    }).catch((error) => {
                        alert('Error deleting record content.');
                    });
                }
            }
    ```
    

1. 실행하면 delete-record-content랑 delete-record   두개가 작동이 됨 
- record-content
    - 컨트롤러
    
    ```java
    @DeleteMapping("/delete-record-content/{recordId}")
        public ResponseEntity<?> deleteRecordContentByRecordId(@PathVariable Long recordId) {
            try {
                recordContentService.deleteContentsByRecordId(recordId);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    ```
    
    - 서비스 & repository
        
        ```java
        //record id로 삭제
            @Transactional
            public void deleteContentsByRecordId(Long recordId) {
        
                1. Records record = recordsPostsRepository.findById(recordId)
                        .orElseThrow(() -> new IllegalArgumentException("해당 레코드가 없습니다. id=" + recordId));
        
                2. List<RecordContent> contents = recordContentRepository.findByRecords(record);
        
                recordContentRepository.deleteAll(contents);
            }
        ```
        
        서비스가 계속 문제였음. 외래키랑 레포지토리랑 주고받는 형식에 id너무 헷갈려서 계속…
        
        1. recordId를 넘겨받으면, recordsPostrepository에서 레코드 id로 record 객체를 넘겨받음 
        - 이때 RecordsPostsRepository
            
            ```java
            package com.mycompany.myproject.domain.posts;
            
            import org.springframework.data.jpa.repository.JpaRepository;
            import org.springframework.data.jpa.repository.Query;
            import org.springframework.stereotype.Repository;
            
            import java.util.List;
            
            @Repository
            public interface RecordsPostsRepository extends JpaRepository<Records, Long> {
            
                List<Records> findByOrderByRecordIdDesc();
            
            }
            ```
            
        
        1. 이제 그 넘겨받은 record로 recordContentRepository에서 content들을 찾아서 리스트로 반환받음(  List<RecordContent> findByRecords(Records records);
        - RecordContentRepository
            
            ```java
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
            ```
            
        
        1. 그러고 그 리스트를 전부 삭제함

    코멘트 : cascade 선언하면 자동으로 되니까 시도해봐! -> 이 생각을 못했다, 해보자
```
@Entity
public class Records {
    ...

    @OneToMany(mappedBy = "records", cascade = CascadeType.REMOVE)
    private List<RecordContent> recordContents;
}
```
    
    # 할것
    
    1. 원래 했었는데 수정 반영 안되는것(여기는 mustache로 바꿔주면서 생긴 경로 문제 같기는 하다)
    2. 부트스트랩 css 적용
