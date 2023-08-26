function generateContentsFields(recordId) {

    if(!recordId){
        alert("No RecordId");
    }else{
       alert("템플릿 생성 성공!");
    }

    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    var existingTemplateContainer = document.getElementById("templateContainer");
        if (existingTemplateContainer) {
            var hasContent = Array.from(existingTemplateContainer.getElementsByTagName("input")).some(input => input.value);
            if (hasContent && !confirm("기존 내용을 지우고 새로운 템플릿을 생성하시겠습니까?")) {
                return;
            }
            existingTemplateContainer.remove();
        }

    // 날짜 차이 계산
    var start = new Date(startDate);
    var end = new Date(endDate);
    var timeDiff = Math.abs(end.getTime() - start.getTime());
    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); // 차이 일 수 계산

    // 텍스트 칸 동적 생성
    var templateContainer = document.createElement("div");
    templateContainer.setAttribute("style", "margin-top: 20px;"); // 여백 추가

    for (var i = 0; i <= diffDays; i++) {
        // 각 날짜와 입력 칸을 포함하는 컨테이너 생성
        var entryContainer = document.createElement("div");
        entryContainer.setAttribute("style", "margin-bottom: 10px; display: flex; align-items: center;"); // 여백 및 스타일 추가

        var dateSpan = document.createElement("span");
        dateSpan.textContent = startDate;
        dateSpan.setAttribute("style", "margin-right: 10px; font-weight: bold;"); // 날짜 오른쪽 여백 및 스타일 추가

        var textField = document.createElement("input");
        textField.setAttribute("type", "text");
        textField.setAttribute("placeholder", startDate);
        textField.setAttribute("style", "width: 500px; height:300px; padding: 5px;"); // 너비 및 패딩 추가


        entryContainer.appendChild(dateSpan);
        entryContainer.appendChild(textField);
        templateContainer.appendChild(entryContainer);


        startDate = getNextDay(startDate); // 다음 날짜 계산
    }

     var saveButton = document.createElement("button");
       saveButton.textContent = "내용 저장";
       saveButton.addEventListener('click', function() {
       var contentInputs = templateContainer.querySelectorAll("input");
       var contentData = [];

        contentInputs.forEach(input => {
            contentData.push({
            date: input.getAttribute("placeholder"),
            content: input.value
             });
        });
        sendDataToServer(contentData);
     });

templateContainer.appendChild(saveButton);


function sendDataToServer(data) {
    var totalCount = data.length;
    var processedCount = 0;

    data.forEach(content => {
        // 체크하여 record content가 이미 존재하는지 확인
        $.ajax({
            type: "GET",
            url: "/check-record-content",
            data: {
                recordId: recordId,
                date: content.date
            },
            success: function(response) {
                var recordContentId = response;

                // record content가 이미 존재하면 업데이트, 그렇지 않으면 삽입
                var url = recordContentId != null ? "/update-record-content/" + recordContentId : "/add-record-content";
                var type = recordContentId != null ? "PUT" : "POST";

                $.ajax({
                    type: type,
                    url: url,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        recordId: recordId,
                        content: content.content,
                        date: content.date
                    }),
                    success: function() {
                        processedCount++;

                        if (processedCount === totalCount) {
                            alert("저장 성공!");
                        }
                    },
                    error: function(err) {
                        alert("저장 실패 : " + (err.responseJSON && err.responseJSON.message) || err.responseText || "알 수 없는 오류");
                    }
                });
            },
            error: function(err) {
                alert("체크 실패 : " + (err.responseJSON && err.responseJSON.message) || err.responseText || "알 수 없는 오류");
            }
        });
    });
}


    // 생성된 텍스트 칸을 본문 아래에 추가
    var body = document.getElementsByTagName("body")[0];
    body.appendChild(templateContainer);
}

function getNextDay(dateString) {
    var date = new Date(dateString);
    date.setDate(date.getDate() + 1);
    var nextDay = date.toISOString().split('T')[0];
    return nextDay;
}