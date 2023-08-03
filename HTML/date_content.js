function generateContentsFields() {
    var startDate = document.getElementById("start-date").value;
    var endDate = document.getElementById("end-date").value;

    // 날짜 차이 계산
    var start = new Date(startDate);
    var end = new Date(endDate);
    var timeDiff = Math.abs(end.getTime() - start.getTime());
    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); // 차이 일 수 계산

    // 텍스트 칸 동적 생성
    var templateContainer = document.createElement("div");
    for (var i = 0; i <= diffDays; i++) {
      var dateSpan = document.createElement("span");
       dateSpan.textContent = startDate;

        var textField = document.createElement("input");
        textField.setAttribute("type", "text");
        textField.setAttribute("placeholder", startDate);

        templateContainer.appendChild(dateSpan);
        templateContainer.appendChild(textField);
        templateContainer.appendChild(document.createElement("br")); // 줄 바꿈 추가
        startDate = getNextDay(startDate); // 다음 날짜 계산
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
