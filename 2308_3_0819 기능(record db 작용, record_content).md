# 0819 기능(record db 작용, record_content)

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/6ba33136-ac8d-432f-8720-441c185521d3.png"/>



데이터베이스랑 테이블의 컬럼이나 타입 일치문제, 변수명 등으로 엄청 오래걸림

# 1. new_travel_record.html 페이지에서 기본정보 입력

1. new_travel_record.html 접속 - 기본 정보(제목/장소/날짜들)입력 
    
<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/d3592edf-8f44-4343-af69-99c45306c605.png"/>

    

# 2. Record Id 전달 문제

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/89dcda68-ff3a-4403-a5ef-75032db3db84.png"/>


1. 기본정보 저장을 누르면 record-functions.js - handleFormSubmit함수 호출 : db에 save
    
 <img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/f40c77fd-0f80-4e00-997b-49a91aac5ef5.png"/>

    
  <img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/8bf22700-5e9b-44d9-bd79-1eaf505bd15a.png"/>

    
2. 이때 recordId는 record_content 테이블에서 활용하기 위해 필요함

30

a. html에서 전역변수로 recordId 선언

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/42b64094-125a-45b0-b9d2-2d2ebc34cd5c.png"/>

b. 서비스 코드 상 서버에서 받은 response응답이 곧 recordId임. 전역변수 recordId에 값을 넣어줌

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/b3aba577-aea5-4bc1-b861-1864dfca26d5.png"/>

- add-record → 컨트롤러 통해서 → RecordsService

    ```java
public Long update(Long recordId, RecordsSaveRequestDto requestDto) {
    Records records = recordsPostsRepository.findById(recordId)
        .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" +  recordId));
    records.update(requestDto.getRecordTitle(), requestDto.getLocation(), requestDto.getStartDate(), requestDto.getEndDate());
    return recordId;
}
```
            
            여기서 recordId를 리턴하도록 짜놨는데, response.recordId로 접근하려니까 계속 받아지지가 않았음. response그 자체가 recordId였음 

            
        - record-functions.js에서 받아진 recordId
            
    <img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/475e1158-761b-4350-a06e-6966de48ae21.png"/>


            
        - html페이지의 전역변수에 잘 할당되었나(show recordId 버튼으로 alert)

            
        <img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/4f17cc92-f04a-4c31-a5af-df709dc605bc.png"/>


            
        
        - 그 recordId가 record_content에 전달이 되었나

            
       <img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/4616d0de-0ca2-4388-a915-968cbe39dbcb.png"/>

            
    

# 3. 템플릿 생성

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/e4bd8560-061d-4e43-a8a2-fd20fa772023.png"/>

기본 정보의 날짜에 따라서 템플릿 생성 : data_content.js에서.

# 4. record_content 테이블에 저장

각각의 content를 받아서 record_content 테이블에 insert함

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/21daabdd-f7c3-461d-8061-f99c4fec9d99.png"/>


1. 이제 도메인, 서비스, 디토, 컨트롤러를 싹 새로 만듦… 

1. record_content 테이블도 db에 만들어줌 

오류 줄줄이 나던것들

- 타입문제
- 그냥 레코드 할때는 문제가 없었는데 RECORD_CONTENT로 테이블 만들었더니 record_content 소문자 찾고 있길래 테이블 명을 소문자로 바꿈
    
    `java.sql.SQLException: Table 'mango.record_content' doesn't exist`
    

1. 또 record id 문제 

`Query is: insert into record_content (content, date, hashtag, record_id) values (?, ?, ?, ?), parameters ['sss','2023-08-16',<null>,<null>]`

Dto를 만들때 문제였음 

솔직히 오류가 너무 많아서 어디는 records..record_id..recordId..RecordContent… 어쩌구 이래서 정확히 뭐가뭔지 헷갈린다 

다만 이때는 Dto확인을 하는걸 까먹어서 뱅뱅 돌음

1. 그렇게 했을때 저장은 됨

레코드 id - 각 날짜에 대해서 content가 각각 들어가고, 주키는 record_content_id로 구분이 된다

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/58bebe0c-d0c1-44c9-ad49-5895c8c812d5.png"/>


# 5. 하는중=막힌것 : record_content 업데이트

<aside>
💡 상황 가정

</aside>

1. 여기서 적다가 중간에 내용저장을 눌렀어. 이어서 작성하고 또 내용저장을 누르면 새로운 행을 insert하는게 아니라, 기존의 행을 update해야함
   
    
    <img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/9b659ca3-bb63-43e3-9bfa-46de3bde3bd0.png"/>

    

2. 아직 멀었지만 나중에 이미 있는 record를 불러와서 수정할때(이건 또 언제..ㅎㅎ;;) 이미 있는 값을 업데이트 해야함

<aside>
💡 원하는 로직

</aside>

1. date_content.js에서 recordId와 date가 같은 행들이 존재하면 update
2. 존재하지 않으면 save로.

<img width="50%" src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/eb5a2449-99cd-4b12-841b-5f538dbac3cb.png"/>


<aside>
    
💡 추가되는 것들

</aside>

1. 이미 존재하는지 확인할 /check-record-content의 컨트롤러 서비스 dto repository…
2. 업데이트할 /update-record-content의 “….


# *

버튼을 눌렀는데 왠지 그냥 작동을 안한다면

인텔리제이에서 빨간줄도 안띄워주는 JS파일의 문법오류

인 경우가 많았는데

콘솔 f12확인을 할 생각을 안했었다.

바로바로 확인해주자…
