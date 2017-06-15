$(function () {
//	var $url_reg = /[http|https][:\/\/][^\s]*/;

    var main = {
        request:{},
        param:{}
    }

    main.param.process = function () {
        var url = $("#inter_url").val();

        var method = $('input[name="method"]:checked').val();

        /*if (url == undefined || $url_reg.test(url)) {
         return 0;
         }*/

        //get params
        var params = "";
        var i = 0;
        var pNames, pValues;
        $('input[name="paramName"]').each(function () {
            var pname = $(this).val();
            if (pname != "") {
                var pvalue = $(this).parent().siblings('div').children('input[name="paramValue"]').val();

                if (pvalue != "") {
                    var param = pname + '='
                        + pvalue + '&';
                    params = params + param;
                    pNames[i] = pname;
                    pValues[i] = pvalue;
                    i++;
                }
                ;

            }
            ;
        });

        if (method == 0 && params != '') {
            $("#inter_url").val('');
            $("#inter_url").val(url + '?' + params);
        }

    };
    
    main.request.go = function ($form, $target_area) {
        $.ajax({
            url: "request",
            type: 'post',
            contentType: "application/json",
            dataType: "json",
            data: $form.serialize(),
            error: function () {
                $target_area.html("error");
            },
            success: function (data) {
                $target_area.html();
                $("<iframe id='result_frame' style='margin: 100px auto auto 50px; width: 1200px; height: 800px' frameborder='no' marginheight='0' marginwidth='0' allowTransparency='true' >"+"" +
                    data.code + "<br>"+data.message + "<br>" + data.data + "</iframe>")
                 .prependTo('#result');
                 $("#result_frame").attr("src", url + params);
                // $('#result_frame').src = url+params;
            }
        });
    }
    
    $('#go_submit').on('click', function () {





    });

});