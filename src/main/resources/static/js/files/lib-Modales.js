$(function () {
    $("#tbl").DataTable({
        "language": {
            "url": "/static/plugins/datatables/Spanish.json"
        },
        "responsive": true,
        "lengthChange": true,
        "autoWidth": true,
        "dom": 'flrtipB',
        "buttons": ["excel", "pdf", "csv", { extend: "print", text: "Imprimir" }], //{ extend: 'colvis', text: 'Columnas visibles', postfixButtons: ['colvisRestore'] }],
        "columnDefs": [
            { targets: 'no-sort', orderable: false }
        ]
        //"responsive": true, "lengthChange": false, "autoWidth": false
    }).buttons().container().appendTo('#tbl_wrapper .col-md-auto:eq(0)');

});

function CalcularTotal(data)
{
    //console.log(data)
    var totals = [0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0];
    var $filas= $("#tbl tr:not('.total, .encabezado')");
    let pesoMXN = Intl.NumberFormat("es-MX", {
        style: "currency",
        currency: "MXN",
        useGrouping: true,
    }); // $147,741.15
    $filas.each(function() {
        $(this).find('td').each(function(i) {
            if (i !== 0 && i!== 2)
                totals[i - 1] += parseFloat($(this).html());
        });
    });
    $(".total th").each(function(i) {
        if (i !== 0)
            $(this).html(totals[i - 1]);
        if(i===5||i===9)
            $(this).html(pesoMXN.format(totals[i - 1]));
        if (i===6||i===10)
            $(this).html(dosDecimales(totals[i - 1]) + " UM03")
    });
    var j = 0
    var k = 0
    $filas.each(function() {
        $(this).find('td').each(function(i) {
            if(i===5){
                var id = j++
                $(".currency1_"+id.toString()).text(pesoMXN.format($(".currency1_"+id.toString()).text()));
            }
            if(i===9){
                var id = k++
                $(".currency2_"+id.toString()).text(pesoMXN.format($(".currency2_"+id.toString()).text()));
            }
        });
    });
}


function convertir(data) {
    var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    var $filas= $("#tbl tr:not('.total, .encabezado')");
    var j = 0
    $filas.each(function() {
        $(this).find('td').each(function(i) {
            if (i=== 2){
                var id = j++
                var inputMes = $(".fecha_"+id.toString()).text().split("-")
                var month = inputMes[1]
                if( !isNaN(month) && month >= 1  && month <= 12 ) {
                    $(".fecha_"+id.toString()).text(meses[month - 1] + " " + inputMes[0]);
                }
            }
            if (i===1||i===6||i===10){

            }
        });
    });
}
function dosDecimales(n) {
    let t=n.toString();
    let regex=/(\d*.\d{0,2})/;
    return t.match(regex)[0];
}

function detectNegativeNumbers() {
    //grab all td elements in your table
    var tds = document.querySelectorAll(".table td");
    //iterate over each td
    for (var i = 0; i < tds.length; i++) {
        var text = tds[i].innerText;
        let num = parseFloat(text)
        //check for your target text
        if (!isNaN(num)){
            if (Math.abs(num) !== num) {
                if (num<0){
                    tds[i].classList.add("hasNegative");
                }
            }
        }
    }
}