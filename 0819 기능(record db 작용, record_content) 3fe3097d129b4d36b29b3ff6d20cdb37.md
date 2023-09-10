# 0819 기능(record db 작용, record_content)

![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled.png)

데이터베이스랑 테이블의 컬럼이나 타입 일치문제, 변수명 등으로 엄청 오래걸림

# 1. new_travel_record.html 페이지에서 기본정보 입력

1. new_travel_record.html 접속 - 기본 정보(제목/장소/날짜들)입력 
    
    ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%201.png)
    

# 2. Record Id 전달 문제

![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%202.png)

1. 기본정보 저장을 누르면 record-functions.js - handleFormSubmit함수 호출 : db에 save
    
    ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%203.png)
    
    ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%204.png)
    
2. 이때 recordId는 record_content 테이블에서 활용하기 위해 필요함
    1. html에서 전역변수로 recordId 선언
        
        ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%205.png)
        
    2. 서비스 코드 상 서버에서 받은 response응답이 곧 recordId임. 전역변수 recordId에 값을 넣어줌
        
        ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%206.png)
        
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
            
            ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%207.png)
            
        - html페이지의 전역변수에 잘 할당되었나(show recordId 버튼으로 alert)
            
            ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%208.png)
            
        
        - 그 recordId가 record_content에 전달이 되었나
            
            ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%209.png)
            
    

# 3. 템플릿 생성

![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%2010.png)

기본 정보의 날짜에 따라서 템플릿 생성 : data_content.js에서.

# 4. record_content 테이블에 저장

각각의 content를 받아서 record_content 테이블에 insert함

![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%2011.png)

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

![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%2012.png)

# 5. 하는중=막힌것 : record_content 업데이트

<aside>
💡 상황 가정

</aside>

1. 여기서 적다가 중간에 내용저장을 눌렀어. 이어서 작성하고 또 내용저장을 누르면 새로운 행을 insert하는게 아니라, 기존의 행을 update해야함
    
    ![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%2010.png)
    

1. 아직 멀었지만 나중에 이미 있는 record를 불러와서 수정할때(이건 또 언제..ㅎㅎ;;) 이미 있는 값을 업데이트 해야함

<aside>
💡 원하는 로직

</aside>

1. date_content.js에서 recordId와 date가 같은 행들이 존재하면 update
2. 존재하지 않으면 save로.

![Untitled](0819%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC(record%20db%20%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC,%20record_content)%203fe3097d129b4d36b29b3ff6d20cdb37/Untitled%2013.png)

<aside>
💡 추가되는 것들

</aside>

1. 이미 존재하는지 확인할 /check-record-content의 컨트롤러 서비스 dto repository…
2. 업데이트할 /update-record-content의 “….

이것들 추가하다가 막힘 

해야됨

# *

버튼을 눌렀는데 왠지 그냥 작동을 안한다면

인텔리제이에서 빨간줄도 안띄워주는 JS파일의 문법오류

인 경우가 많았는데

콘솔 f12확인을 할 생각을 안해서 삽질함

바로바로 확인해주자…