$(function() {
    /* 전역 변수로 컨텍스트 경로 값을 설정 */
    $.ajax({
        url: '/LotteON/product/mainProdCate2',
        type: 'GET',
        data: '',
        success: function(data) {
            console.log("1");
            console.log(data);

            $('.category').children().remove();
            $('.category').append(data);
        },
        error: function(){
            console.log('error');
        }
    });
});