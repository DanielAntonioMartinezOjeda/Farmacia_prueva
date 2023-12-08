// FUNCION DE CARGA INICIAL
$(function() {
    $('div#loading_block').remove();
    var path = window. location. pathname;
    var page = path. split("/"). pop();
    if (page.toString() === "jsonMesTable"){
        convertDate()
    }
    loadTableOptions()
});

function detailModalFunctionDiario(volumId){
    $.get("/productoModalDiario?volumId=" + volumId, function (data) {
        $('#detailModal').find('.modal-body').html(data);
        detectNegativeNumbers()
    })
    $('#detailModal').find('.modal-title').html('Productos');
    $("#detailModal").modal('show');
}

function detailModalFunctionMes(volumId){
    $.get("/productoModal?volumId=" + volumId, function (data) {
        $('#detailModal').find('.modal-body').html(data);
        CalcularTotal(data);
        convertir(data)
    })
    $('#detailModal').find('.modal-title').html('Productos');
    $("#detailModal").modal('show');
}

function deleteModalFunction(volumId){
    Swal.fire({
        title: '¿Estás seguro?',
        text: "Esta acción no se puede revertir!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar!',
        allowOutsideClick: false
    }).then((result) => {
        if (result.isConfirmed) {
            $.get("/file/deleteVolumId?volumId=" + volumId);
            Swal.fire({
                title: 'Eliminado!',
                text: "Volumetrico eliminado.",
                icon: 'success',
                allowOutsideClick: false
            }).then((result) => {
                if (result.isConfirmed) {
                    document.location.reload()
                }
            })
        }
    })
}

function convertDate(){
    const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    const $filasSummary= $("#tblSummary tr:not('.encabezado')");
    let j = 0
    $filasSummary.each(function() {
        $(this).find('td').each(function(i) {
            if (i=== 2){
                const id = j++;
                const fechaM = ".fechaM_" + id.toString()
                const inputMes = $(fechaM).text().split("-");
                const month = inputMes[1];
                if( !isNaN(month) && month >= 1  && month <= 12 ) {
                    $(fechaM).text(meses[month - 1] + " " + inputMes[0]);
                }
            }
        });
    });
}

function loadTableOptions(){
    $("#tblSummary").DataTable({
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
    }).buttons().container().appendTo('#tblSummary_wrapper .col-md-auto:eq(0)');
}