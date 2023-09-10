# 0902 기능추가(record_content+세부조회 페이지)

# 1. record_content

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/9fc67c7b-c5cb-4f34-a74f-15a7ef78a801.png" alt="Untitled" width="50%">
- 기본정보 제목/장소/날짜 입력하면 DB에 반영 후 날짜에 따라 템플릿 생성하는것(저번까지 함)
- 세부정보 입력-내용 저장누르면 record_content 여행기록 세부 내용 테이블에 입력됨
- 다시 내용 수정하고, 내용저장 또 눌렀을때 update 하는것 성공(전에는 계속 새로운 content id를 가지는 행을 add 했었음)

- 9번 부분 보면 update 성공
    
<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/828ec3dd-164a-4c4a-bfda-c0ee04bbd892.png" alt="Untitled 1" width="50%">

 <img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/bc7b98af-48d3-4690-b6ed-42cb50d6cdda.png" alt="Untitled 2" width="50%">

 
 <img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/67a5cd7a-d5b0-40ad-9560-3790df43593b.png" alt="Untitled 3" width="50%">

# 2. 여행 기록 리스트 보는 페이지

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/ccaa2596-b20e-45a9-bc8f-de248f6b9d52.png" alt="Untitled 4" width="50%">


# 3. 여행 기록 상세 조회 페이지

<img src="https://github.com/minjiKim87/SpringAWS_Study/assets/68892132/2709ded1-5248-43ad-85b6-35861d612089.png" alt="Untitled 5" width="50%">

- 리스트에서 누르면 record id받아서 내용 띄워줌
- 아직 record_content 본문을 밑에 띄우지는 못함

# 4. 할것

## 부가적인것

- 여행기록 상세보기 페이지에서, 본문 내용을 밑에 띄워야됨
- new_travel_record.html (본문 포함한 새로운 기록 만드는 기존 페이지)로 이어지는 버튼
- 계획 db 받아와서 연동하는 것 등등

## 새 페이지, 다음 기능

- 상세보기 페이지에서 기존 기록 수정 페이지로 넘어가도록.
- 기록 수정 페이지에서, 기존의 기본 정보, 본문등을 보여주고 업데이트 하게.

