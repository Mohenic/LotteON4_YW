$(function() {
    $('.list-delete').click(function(e) {
        e.preventDefault();
        if (confirm("삭제하시겠습니까?")) {
            $('#formCheck').submit();
        }
    });

    // submit 형식 선택지
    $('.btnDelete').click(function(e) {
        e.preventDefault();
        if (confirm("삭제하시겠습니까?")) {
            var formCheck = $('#formCheck');
            if (formCheck.length > 0) {
                formCheck.submit(); // 폼이 있으면 폼을 제출(list page delete)
            } else { // 폼이 없는 경우, 링크로 이동(view page delete)
                if (window.location.href.indexOf('/admin/cs/notice/') !== -1) {
                    var urlParams = new URLSearchParams(window.location.search);
                    var no = urlParams.get('no');
                    window.location.href = '/LotteON/admin/cs/notice/delete?chk=' + no;
                } else if (window.location.href.indexOf('/admin/cs/faq/') !== -1) {
                    var urlParams = new URLSearchParams(window.location.search);
                    var no = urlParams.get('no');
                    window.location.href = '/LotteON/admin/cs/faq/delete?chk=' + no;
                } else if (window.location.href.indexOf('/admin/cs/qna/') !== -1) {
                    var urlParams = new URLSearchParams(window.location.search);
                    var no = urlParams.get('no');
                    window.location.href = '/LotteON/admin/cs/qna/delete?chk=' + no;
                }
            }
        }
    });

    $('.buttonDelete').click(function(e) {
        e.preventDefault();
        if (confirm("삭제하시겠습니까?")) {
            var prodNo = $(this).closest('tr').find('.chk input[type="checkbox"]').val();
            // 클릭된 행에서 체크박스 값을 가져오도록 설정
            window.location.href = '/LotteON/admin/product/delete?chk=' + prodNo;
        }
    });
});
    function confirmDelete() {
        // JavaScript의 confirm 함수를 사용하여 경고 메시지를 표시
        var confirmed = confirm("삭제하시겠습니까?");

        // 확인 버튼이 눌렸을 때만 true를 반환하여 페이지로 이동
        return confirmed;
    }
