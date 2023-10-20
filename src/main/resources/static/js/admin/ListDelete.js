$(function() {
    $('.list-delete').click(function(e) {
        e.preventDefault();
        if (confirm("삭제하시겠습니까?")) {
            $('#formCheck').submit();
        }
    });

    $('.btnDelete').click(function(e) {
        e.preventDefault();
        if (confirm("삭제하시겠습니까?")) {
            var formCheck = $('#formCheck');
            if (formCheck.length > 0) {
                formCheck.submit(); // 폼이 있으면 폼을 제출(list page delete)
            } else {
                // 폼이 없는 경우, 링크로 이동(view page delete)
                var urlParams = new URLSearchParams(window.location.search);
                var no = urlParams.get('no');
                window.location.href = '/LotteON/admin/cs/notice/delete?chk=' + no; // 또는 원하는 URL로 이동
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