$(function() {
	$(document).ready(function() {
	    // Setup - add a text input to each footer cell
	    $('#activityTable tfoot th').each( function () {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Chercher par '+title+'" />' );
	    } );
	 
	    // DataTable
	    var table = $('#activityTable').DataTable();
	 
	    // Apply the search
	    table.columns().every( function () {
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            if ( that.search() !== this.value ) {
	                that
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );
	} );
});

