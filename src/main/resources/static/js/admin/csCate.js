function changeSelectCate() {
    const cate2Select = document.querySelector('select[name=cate2]');
    const typeSelect = document.querySelector('select[name=type]');

    cate2Select.addEventListener('change', function() {
        const cate2 = cate2Select.value;

        // cate2 값에 기반하여 데이터를 가져오기 위한 AJAX 요청 실행
        $.ajax({
            url: '/LotteON/admin/cs/faq/listType?cate2=' + cate2,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log('데이터: ' + data);

                typeSelect.innerHTML = ''; // 기존 옵션 제거
                typeSelect.appendChild(new Option('2차 선택', '0')); // 기본 옵션 추가

                // 데이터를 기반으로 옵션을 추가
                data.forEach(function (item) {
                    typeSelect.appendChild(new Option(item.detail, item.cate3));
                });
            }
        });
    });

    // typeSelect의 변경 이벤트 처리
    typeSelect.addEventListener('change', function() {
        const cate3Value = typeSelect.value;
        const cate2Value = cate2Select.value;

        console.log("cate2 : " + cate2Value);
        console.log("cate3 : " + cate3Value);

        // 현재 페이지 URL을 가져오기
        const currentURL = window.location.href;

        // 페이지 리로드
        if (currentURL.includes("/admin/cs/faq/list")) {
            window.location.href = "/LotteON/admin/cs/faq/list?cate2=" + cate2Value + "&type=" + cate3Value + "&pg=1";
        } else if (currentURL.includes("/admin/cs/qna/list")) {
            window.location.href = "/LotteON/admin/cs/qna/list?cate2=" + cate2Value + "&type=" + cate3Value + "&pg=1";
        }
    });
}

// 창이 로드될 때 changeSelect 함수 호출
window.onload = function() {
    changeSelectCate();
}