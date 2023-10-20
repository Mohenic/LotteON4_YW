function changeSelect() {

    const selectValue = $('select[name=prodCate1]').val();

    console.log(selectValue);

    $.ajax({
        url: '/LotteON/admin/product/registerCate2?selectValue=' + selectValue,
        type: 'GET',
        dataType: 'json',
        success: function (data) {

            console.log("data" + data);

            const cate2Select = $('select[name=prodCate2]');


            cate2Select.empty();
            cate2Select.append($('<option>', {
                value: 'cate0',
                text: '2차 분류 선택'
            }));
            $.each(data, function (index, item) {
                cate2Select.append($('<option>', {
                    value: item.cate2,
                    text: item.c2Name
                }));
            });
        }
    });
}

$(function () {

    $('select[name=prodCate2]').change(function () {

        let cate1 = $('select[name=prodCate1]').val();
        let cate2 = $(this).val();


        let actionUrl = "/admin/product/register?prodCate1=" + cate1 + "&prodCate2=" + cate2;
        $('#formRegister').attr('action', actionUrl);


    });

    $('input[name=price]').focusout(function () {
        const price = $(this).val();
        const point = $('input[name=point]');

        point.val(price * 0.01);
    });

});