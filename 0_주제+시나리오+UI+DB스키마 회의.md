

# USE CASE 시나리오

| 여행 계획 | 목표 : 사용자는 여행 계획을 작성 및 저장할 수 있어야 한다.
1. 조건 : 사용자는 로그인 상태여야 한다.
2. 여행 계획 작성 페이지로 이동
3. 여행 계획 필수 정보 입력(제목/장소/일자 etc)
4. 여행 계획 부가 정보 입력(예산 etc)
5. 여행 계획 체크리스트 항목 작성
6. 저장 버튼 클릭
7. 입력된 여행 계획 정보를 받아 DB에 저장한다
8. 성공 메시지 사용자에게 표시

예외
1. 필수 정보 입력하지 않고 저장 버튼 클릭 시 오류 메시지 표시(필수 정보 입력 요청)
2. 사용자가 입력한 정보가 유효하지 않은 형식일 경우 오류 메시지 표시(올바른 형식 정보 입력 요청)
후처리
1. 작성된 일지를 클릭해서 편집 없이 볼 수 있다.
2. 여행 계획 ‘편집’ 버튼 클릭시 편집 페이지로 이동
3. 여행 계획 ‘삭제’ 버튼 클릭시 재확인 메시지를 띄운 후 ‘확인’ 클릭 시 삭제한다.
4. 최초 계획에서 작성된 체크리스트는 여행계획 전체 편집 없이도 수정 가능하다.
    1. 항목 완료/삭제/보류 등등 |
| --- | --- |
| 여행 기록 | 목표 : 여행 기록 작성 및 저장
1. 조건 : 사용자는 로그인 상태여야 하며, 여행기록을 작성하려는 여행 계획이 이미 시스템에 저장되어 있어야 한다.
2. 여행 기록 작성 페이지로 이동
3. 여행 기록과 연결된 여행 계획을 선택한다.
4. 여행 계획의 필수 정보를 불러온다(자동 표시)
5. 여행 계획의 부가 정보를 불러온다(선택 표시?)
6. 여행 기록 제목 입력
7. 여행 기록 내용 입력
    1. 텍스트, 이미지, 동영상(가능?) 포함 가능
8. 저장 버튼 클릭
9. 입력된 여행 기록 정보를 받아 DB에 저장한다.
10. 성공 메시지 사용자에게 표시

예외
• 위와 동일
후처리
• 1~3 위와 동일
• 게시글에 업로드한 이미지를 모아볼 수 있다(부가기능 그냥 생각) |
| 여행 정보 | 목표 : 여행 정보 기록 및 저장
1. 조건 : 사용자는 로그인 상태여야 한다.
2. 여행 계획이 시스템에 존재해야 한다.(존재하지 않아도 될지도. 일단은 여행 계획을 세우고, 그 관련된 정보들을 기록하는 것으로 생각)
3. 여행 정보 기록 페이지로 이동한다.
4. 정보를 기록하려는 여행 계획(제목)을 선택한다.
5. 여행 정보의 종류를 선택한다
    1. 음식점, 관광지, 숙소 등
6. 선택한 여행 정보의 세부 정보를 입력한다.
    1. 이름, 위치, 시간, 평점, 외부 url, 사진, 메모
7. 저장 버튼 클릭
8. 입력된 여행 정보를 받아 데이터베이스에 저장한다.
9. 성공 메시지를 사용자에게 표시한다.

예외
• 위와 동일
후처리
• 1~3과 동일 |
| 회원 가입 및 로그인 | 1. 로그인 페이지로 이동한다.
2. 등록된 이메일/비밀번호를 입력한다.
3. ‘로그인’ 버튼 클릭
4. 입력된 정보를 검증
5. 정보가 올바르면 사용자를 인증하고 메인 페이지로 리다이렉트
예외
사용자가 등록되지 않은 이메일 또는 사용자 이름, 또는 잘못된 비밀번호를 입력하는 경우, 시스템은 오류 메시지를 표시하고 사용자에게 다시 시도하도록 요청한다. |

# UI

첫 페이지 / 기능별 메인페이지(모아보기) + 세부 view + edit 구조로 생각

### 메인 페이지

<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/e3aedfcf-6c8c-4d37-bc5a-526f439f05a7" width="90%">

### 여행 계획
<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/1d79045e-be21-4a5e-baab-3a7766d9f4e8" width="50%">

### 여행 기록


<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/d97cbdcc-df57-4de7-a39c-a69fd495fe4b" width="50%">


### 여행 정보

<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/d12c800c-754c-40bd-a7f9-5683ede24372" width="50%">

# 추가

- 검색 기능!

| 좌측 사이드바 | • 좌측 사이드바
    ◦ 만들어만 두자
    ◦ 가능한 내용 : 커뮤니티, 공지사항, 문의사항 등 다른 기능들이 들어가지 않을까. 지금 여행 계획/기록과 관련해서는 사이드바를 운용할 필요가 없을것 같다. |
| --- | --- |
| 추가 의견 | 여행계획/기록/정보 3개니까 하나 더 주제 해야되면 커뮤니티페이지(한별 ui 참고) 만들어도 되지 않을까 |
| 흐름 | 여행기록 기능 사용 흐름 |
| 고려 기능 | 임시저장 / 사이드 내비게이션 바 / 에디터 문제 |
| DB 스키마 | 밑에. |

# 여행기록 담당 회의 정리

## UI

<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/0b85b8c9-d180-42e7-9a44-7cd5400b1170" width="50%">

<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/71d05158-b03d-4e21-bce9-5ce42f7a3c44" width="50%">



<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/bb61765b-20fb-4b91-8d5e-8b0acc3be967" width="50%">

흐름

메인페이지 -> 여행기록 페이지 ->

- 새로만들기 (로그인 x시 로그인페이지 -> 여행기록 페이지)
- 상세 view 클릭 -> 수정하기(->임시저장->휘발성flash 메시지->기존 편집 화면 / 저장->여행 상세보기view) / 삭제하기(with 팝업창)

<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/c0e62a1e-f2aa-417d-bde8-55cdbd066aff" width="50%">

## 추가 고민

1. 우측 사이드 내비게이션 바 : 여행 기록 상세 조회 페이지
    - 사이드 내비게이션바 r기능 고민
        1. day1을 보고 있을때 나머지 day들을 day2, day3들로만 표시
        2. day의 내용에는 본문에서 추출된 해시태그(최대10개)가 보여짐
            1. 7자 이상의 해시태그는 뒷부분 …으로 축약 ex) #123456…
        3. day를 누르면 그 day로 이동하면서, 해당 day의 해시태그만 펼쳐서 보여준다.
        4. 해시태그를 누르면 day 본문 중 해당 부분으로 이동 가능.
2. 작성 형식
    1. 에디터(네이버 에디터 2.0)
        1. 각 day별로 작성 및 분류가 힘듦(그냥 네이버 블로그가 됨)
    2. 마크다운 텍스트와 이미지 only(깃허브)
        1. 사용자가 불편함 개발자는 편함
    3. 노션 형식 : 사용자는 가장 편해보이나 개발자는 구현을 찾아봐야함
        1. 드래그시 팝업으로 글자 수정

# api 임시 작성

## **[USER]유저**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| user_key | INT(기본키, 자동증가) | 유저 고유 넘버 |
| user_id | varchar(255) | 유저 id |
| user_password | varchar(255) | 유저 패스워드 |
|  |  |  |

## **[RELATION]통합 ID 관계**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| main_id | INT, 자동 증가) | 계획 id랑 기록 id를 한 번에 관리할 수 있으면 좋지 않을까? 해서. |
| user_key |  | 외래키 |
| plan_id | INT | 계획 ID |
| record_id | INT | 기록 ID |

## **[INFO]기본정보**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| main_id | INT | 메인 ID로 관리, 외래키가 기본키, 식별관계 |
| plan_title | VARCHAR(255) |  |
| record_title | VARCHAR(255) |  |
| location | VARCHAR(255) | 여행 장소 |
| start_date | DATE | 시작 날짜 |
| end_date | DATE | 종료 날짜 |

## **[INFO]기본정보**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| main_id | INT | 메인 ID로 관리, 외래키가 기본키, 식별관계 |
| plan_title | VARCHAR(255) |  |
| record_title | VARCHAR(255) |  |
| location | VARCHAR(255) | 여행 장소 |
| start_date | DATE | 시작 날짜 |
| end_date | DATE | 종료 날짜 |

## **[RECORD]여행 기록**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| record_id | INT ) | 각 기록 고유 아이디 |
| main_id |  | 외래키 기본키 |
| record_content | varchar(1000?)[]배열 | 각 일자별 기록에 해당하는 본문 텍스트의 배열 // 몇글자 제한 둘까? |
| content_hashTag | varchar(100?([]배열 | 본문에서 추출된 해시태그의 배열.// 일자별 구분 없이 통합시. 일차배열, 아니면 다시 고려. 몇글자 제한 둘까? |

## **[COSTS]비용**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| record_id | INT | 해당 비용 정보가 어떤 여행 기록에 해당하는지를 알려주는 Foreign Key |
| cost_id | INT(기본 키, 자동 증가) | primary key, 각 비용 고유 ID |
| category | varchar(255) | 식비, 숙소, 교통, 기타 |
| description | varchar(255) | 사용자가 추가할 세부 내역 ex아침밥 |
| amount | int | 해당 비용의 금액 |

## **[PHOTOS] 사진들**

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| image_id | INT (, 자동 증가) | 각 이미지 고유 아이디 |
| main_id | INT | 해당 이미지가 어떤post에 해당하는지를 알려주는 외래키 |
| file_name | VARCHAR(255) | 업로드 된 파일의 이름 |
| dlal | VARCHAR(255) | 이미지 파일의 저장 경로(파일 시스템이나 클라우드 저장소에…이미지 자체를 db에 저장하면 용량 급격히 증가한대) |
| upload_date | TIMESTAMP | 이미지가 업로드 된 날짜와 시간 |

# 최종 팀 DB 스키마

[trip](https://www.erdcloud.com/d/WXpvfeaSCdjnedrmN)

<img src="https://github.com/minjiKim87/Man_go-Trip_PersonalKMJ/assets/68892132/85dbc2c6-e5fa-4272-9202-b11d758e0f39" width="90%">

| USER |  |  |  |  |  |  |  |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 사용자 id | user_id |  | int | N |  | Auto increment |
|  | 이메일 | user_email |  | varchar(255) | N |  |  |
|  | 비밀번호 | user_password |  | varchar(255) | N |  |  |
|  | 닉네임 | user_name |  | varchar(255) | Y |  | 안 쓰면 이메일 넣어주기! |
|  |  |  |  |  |  |  |  |
| PLAN |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 계획 id | plan_id |  | int | N |  | auto increment |
|  | 계획 제목 | plan_title |  | varchar(255) | N |  |  |
|  | 여행지 | location |  | varchar(255) | N |  |  |
|  | 작성 시각 | post_date |  | datetime | N |  |  |
|  | 여행 시작일 | start_date |  | date | N |  |  |
|  | 여행 종료일 | end_date |  | date | N |  |  |
|  | 여행 진행 상태 | trip_state |  | tinyint | N |  |  |
|  | 예산 | budget |  | decimal(8,2) | Y |  |  |
|  |  |  |  |  |  |  |  |
| RECORDS |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 기록 ID | record_id |  | long | N |  | auto increment |
|  | 기록 제목 | record_title |  | varchar(255) | N |  |  |
|  | 여행지 | location |  | varchar(255) | N |  |  |
|  | 여행 시작일 | start_date |  | date | N |  |  |
|  | 여행 종료일 | end_date |  | date | N |  |  |
|  |  |  |  |  |  |  |  |
| DATE_PLAN |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 세부내용id | date_plan_id |  | int | N |  |  |
| FK | 계획 id | plan_id |  | int | N |  |  |
|  | 여행 일자 | date |  | int | N |  |  |
|  | 일정 시작 시각 | start_time |  | time | Y |  |  |
|  | 일정 종료 시각 | end_time |  | time | Y |  |  |
|  | 여행 장소 | tour_spot |  | varchar(255) | Y |  |  |
|  | 일정 세부 내용 | content |  | text | Y |  |  |
|  | 비용 | cost |  | decimal(8,2) | Y |  |  |
|  |  |  |  |  |  |  |  |
| RECORD_CONTENT |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 기록세부내용ID | record_contet_id |  | Long | N |  | Auto-Increment |
| FK | 기록 ID | record_id |  | int | N |  |  |
|  | 날짜별내용 | content |  | text | Y |  |  |
|  | 날짜별해시태그 | hashtag |  | varchar(255) | Y |  |  |
|  | 날짜 | date |  | date | N |  |  |
|  |  |  |  |  |  |  |  |
| IMAGE |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 사진 id | image_id |  | INT | N |  | Auto Increment |
| FK | 계획 id | plan_id |  | int | Y |  |  |
| FK | 기록 ID | record_id |  | int | Y |  |  |
|  | 사진 이름 | image_title |  | varchar(255) | Y |  |  |
|  | 사진 경로 | image_url |  | varchar(255) | Y |  |  |
|  |  |  |  |  |  |  |  |
| RELATION |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 게시글관리id | total_id |  | int | N |  | Auto Increment |
| FK | 사용자 id | user_id |  | int | Y |  |  |
| FK | 계획 id | plan_id |  | int | Y |  |  |
| FK | 기록 ID | record_id |  | int | Y |  |  |
|  |  |  |  |  |  |  |  |
| TOTAL_INFO |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| FK | 게시글관리id | total_id |  | int | N |  | Auto Increment |
|  | 통합 장소 | t_location |  | varchar(255) | N |  | 부산. 대전 |
|  | 통합 계획 제목 | t_plan_title |  | varchar(255) | Y |  |  |
|  | 통합 기록 제목 | t_record_title |  | varchar(255) | Y |  |  |
|  |  |  |  |  |  |  |  |
| Record_COST |  |  |  |  |  |  |  |
| 키 | 논리 | 물리 | 도메인 | 타입 | Null 허용 | 기본값 | 코멘트 |
| PK | 비용 id | cost_id |  | Long | N |  |  |
| FK | 기록 ID | record_id |  | Long | N |  | auto increment |
|  | 카테고리 | cost_category |  | varchar(255) | N |  | 식비, 숙소, 교통, 기타 |
|  | 세부내역 | cost_details |  | VARCHAR(255) | Y |  |  |
|  | 금액 | cost_amount |  | decimal(8,2) | Y |  |  |
|  |  |  |  |  |  |  |  |
