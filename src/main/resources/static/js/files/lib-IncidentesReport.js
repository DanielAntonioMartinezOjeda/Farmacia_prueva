// FUNCION DE CARGA INICIAL
$(function() {
    $('div#loading_block').remove();
});

//FUNCION DE ENVIO DE DATOS DE INCIDENTES REPORTADOS AL CONTROLADOR
function exportReportTo(exportType) {
    $.ajax({
        url: 'exportIncidentsReport/' + exportType,
        type: "GET",
        xhr: function () {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 2) {
                    if (xhr.status == 200) {
                        xhr.responseType = "blob";
                    } else {
                        xhr.responseType = "text";
                    }
                }
            };
            return xhr;
        },
        success: function (data) {
            let blob;

            if (exportType === 'xls') {
                //Convert the Byte Data to BLOB object.
                blob = new Blob([data], { type: "application/vnd.ms-excel" });
            } else if (exportType === 'csv') {
                blob = new Blob([data], { type: "text/csv" });
            } else { //pdf
                blob = new Blob([data], { type: "application/pdf" });
            }

            let dt;
            const timestamp = new Date((dt = new Date()).getTime() - dt.getTimezoneOffset() * 60000)
                    .toISOString()
                    .replace(/(.*)T(.*)\..*/, '$1_$2');
            const fileName = "Resumen_validador_JSON_" + timestamp;
            console.log(fileName)
            //Check the Browser type and download the File.
            const isIE = !!document.documentMode;
            if (isIE) {
                window.navigator.msSaveBlob(blob, fileName);
            } else {
                var url = window.URL || window.webkitURL;
                link = url.createObjectURL(blob);
                var a = $("<a />");
                a.attr("download", fileName);
                a.attr("href", link);
                $("body").append(a);
                a[0].click();
                $("body").remove(a);
            }
        },
        error: function (xhr, ajaxOptions, thrownError) {

        }
    });

}