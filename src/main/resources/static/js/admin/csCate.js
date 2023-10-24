/* faq cate2 - type */

function changeSelect() {
    const cate2 = $('select[name=cate2]').val();

    $.ajax({
        url:'/LotteON/admin/cs/faq/listType?cate2='+cate2,
        type: 'GET',
        dataType:'json',
        success: function (data){
            console.log('data'+data);

            const typeSelect =$('select[name=type]');

            typeSelect.empty();
            typeSelect.append($('<option>', {
                value: '0',
                text: '선택'
            }));
            $.each(data, function (index,item){
                typeSelect.append($('<option>',{
                    value: item.cate3,
                    text:item.detail
                }));

            })
        }

    })


}