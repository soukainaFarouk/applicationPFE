function openFilialeModal(id) {
    $.ajax({
        url: location.origin + "/filiale/edit/" + id,
        success: function(response) {
            $('#editFilialeHolder').html(response);
            $('#editFiliale').modal();
            $('#editFiliale').modal('open');
        }
    });
}