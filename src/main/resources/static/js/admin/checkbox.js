$(function() {
    // 전체 선택 체크박스 클릭 이벤트 핸들러
    $('#selectAll').change(function() {
        const isChecked = $(this).is(':checked');
        // 개별 체크박스 상태를 변경
        $('.checkbox').prop('checked', isChecked);
    });

    // 개별 체크박스 클릭 이벤트 핸들러
    $('.checkbox').change(function() {
        const isChecked = $(this).is(':checked');
        // 개별 체크박스 중 하나라도 해제되면 전체 선택 체크박스도 해제
        if (!isChecked) {
            $('#selectAll').prop('checked', false);
        }
    });
});