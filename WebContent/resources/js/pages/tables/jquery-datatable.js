$(function () {
    $('.js-basic-example').DataTable({
        responsive: true
    });

    //Exportable table
    $('.js-exportable').DataTable({
        dom: 'Bfrtip',
        responsive: true,
        buttons: [
            {
                extend: 'excelHtml5',
                title : 'Passengers List',
                exportOptions: {
                	columns: [ 0, 1, 2, 3, 4, 5 ]
                }
            },
            {
                extend: 'pdfHtml5',
                title : 'Passengers List',
                //messageTop: 'Passengers List',
                exportOptions: {
                    columns: [ 0, 1, 2, 3, 4, 5 ]
                }
            },
            {
                extend: 'csvHtml5',
                title : 'Passengers List',
                header : false,
                exportOptions: {
                    columns: [ 0, 1, 2, 3, 4, 5 ]
                }
            }
        ]
    });
});