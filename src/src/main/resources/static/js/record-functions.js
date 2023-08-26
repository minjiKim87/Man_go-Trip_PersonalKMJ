
  ///기존 데이터 보여주는 용도///
//  $(document).ready(function() {
//        $.get("/fetch-records", function(data) {
//    data.forEach(record => {
//        let startDate = new Date(record.startDate).toISOString().split("T")[0];
//        let endDate = new Date(record.endDate).toISOString().split("T")[0];
//
//        $('#recordList').append(`
//            <tr data-id="${record.recordId}">
//                <td class="recordTitle">${record.recordTitle}</td>
//                <td class="location">${record.location}</td>
//                <td class="startDate">${startDate}</td>
//                <td class="endDate">${endDate}</td>
//                <td>
//                    <button onclick="updateRecord(${record.recordId})">업데이트</button>
//                    <button onclick="deleteRecord(${record.recordId})">삭제</button>
//                </td>
//            </tr>
//        `);
//    });
//});

///

function handleFormSubmit() {

        let data = {
            recordTitle: $("#recordTitle").val(),
            location: $("#location").val(),
            startDate: $("#startDate").val(),
            endDate: $("#endDate").val()
        };

        $.ajax({
            headers: {
                'X-CSRF-TOKEN': $('input[name="${_csrf.parameterName}"]').val()
            },
            type: "POST",
            url: "/add-record",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(response) {
                alert("성공적으로 추가되었습니다!");

                //date_content.js에 recordId 넘기는 용도
                recordId = response;
                alert("Received recordId from the server: " + response);


            },
            error: function(err) {
                alert("오류 발생: " + err.responseJSON.message);
            }
        });
    }

window.updateRecord = function(recordId) {
            let recordRow = $('tr[data-id="' + recordId + '"]');
            let fields = ['recordTitle', 'location', 'startDate', 'endDate'];

            fields.forEach(function(field) {
                let cell = recordRow.find('.' + field);
                let value = cell.text().trim();
                let inputType = (field === 'startDate' || field === 'endDate') ? 'date' : 'text';
                cell.html(`<input type="${inputType}" value="${value}">`);
            });

            let updateBtn = recordRow.find('button:contains("업데이트")');
            updateBtn.text('저장');
            updateBtn.attr('onclick', `saveRecord(${recordId})`);
        }

window.saveRecord = function(recordId) {
            let recordRow = $('tr[data-id="' + recordId + '"]');
            let recordTitleInput = recordRow.find('.recordTitle input');
            let locationInput = recordRow.find('.location input');
            let startDateInput = recordRow.find('.startDate input');
            let endDateInput = recordRow.find('.endDate input');

            let data = {
                recordTitle: recordTitleInput.val(),
                location: locationInput.val(),
                startDate: startDateInput.val(),
                endDate: endDateInput.val()
            };

            $.ajax({
                headers: {
                    'X-CSRF-TOKEN': $('input[name="${_csrf.parameterName}"]').val()
                },
                type: "PUT",
                url: "/update-record/" + recordId,
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(response) {
                    alert("성공적으로 수정되었습니다!");
                    recordTitleInput.parent().text(data.recordTitle);
                    locationInput.parent().text(data.location);
                    startDateInput.parent().text(data.startDate);
                    endDateInput.parent().text(data.endDate);
                    let saveBtn = recordRow.find('button:contains("저장")');
                    saveBtn.text('업데이트');
                    saveBtn.attr('onclick', `updateRecord(${recordId})`);
                },
                error: function(err) {
                    alert("오류 발생: " + err.responseJSON.message);
                }
            });
        }

window.deleteRecord = function(recordId) {
            if (recordId === undefined || recordId === null || isNaN(recordId)) {
                alert("유효하지 않은 레코드 ID입니다.");
                return;
            }

            if(confirm("정말로 삭제하시겠습니까?")) {
                $.ajax({
                    url: "/delete-record/" + recordId,
                    type: 'DELETE',
                    success: function(result) {
                        location.reload();
                    }
                });
            }
        }



