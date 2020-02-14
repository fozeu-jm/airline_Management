/**
 * 
 */

$(document).ready(function() {
	/*-------------------------------------
	Select 2 Init
	-------------------------------------*/
	if ($.fn.select2 !== undefined) {
		$('.select2').select2({
			width : '100%',
			height : '150px'
		});
	}

	// Exportable table
	$('.plane-export').DataTable({
		dom : 'Bfrtip',
		responsive : true,
		buttons : [ {
			extend : 'excelHtml5',
			title : 'AirCraft List',
			exportOptions : {
				columns : [ 0, 1, 2, 3, 4 ]
			}
		}, {
			extend : 'pdfHtml5',
			title : 'AirCraft List',
			// messageTop: 'Passengers List',
			exportOptions : {
				columns : [ 0, 1, 2, 3, 4 ]
			}
		}, {
			extend : 'csvHtml5',
			title : 'AirCraft List',
			header : false,
			exportOptions : {
				columns : [ 0, 1, 2, 3, 4 ]
			}
		} ]
	});
	
	// Exportable table
	$('.flight-export').DataTable({
		dom : 'Bfrtip',
		responsive : true,
		buttons : [ {
			extend : 'excelHtml5',
			title : 'Flights List',
			exportOptions : {
				columns : [ 0, 1, 2, 3, 4, 5, 6, 7, 8 ]
			}
		}, {
			extend : 'pdfHtml5',
			title : 'Flights List',
			// messageTop: 'Passengers List',
			exportOptions : {
				columns : [  0, 1, 2, 3, 4, 5, 6, 7, 8 ]
			}
		}, {
			extend : 'csvHtml5',
			title : 'Flights List',
			header : false,
			exportOptions : {
				columns : [  0, 1, 2, 3, 4, 5, 6, 7, 8 ]
			}
		} ]
	});
	
	// Exportable table
	$('.pilot-export').DataTable({
		dom : 'Bfrtip',
		responsive : true,
		buttons : [ {
			extend : 'excelHtml5',
			title : 'Pilot List',
			exportOptions : {
				columns : [ 1, 2, 3, 4, 5, 6 ]
			}
		}, {
			extend : 'pdfHtml5',
			title : 'Pilot List',
			// messageTop: 'Passengers List',
			exportOptions : {
				columns : [ 1, 2, 3, 4, 5, 6]
			}
		}, {
			extend : 'csvHtml5',
			title : 'Pilot List',
			header : false,
			exportOptions : {
				columns : [ 1, 2, 3, 4, 5, 6 ]
			}
		} ]
	});
});