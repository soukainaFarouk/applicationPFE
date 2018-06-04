$(function() {
	$('#addFonction').click(function(){
		var div = $('div[id^="nouvelleFonction"]:last');
		  var num = parseInt( div.prop("id").match(/\d+/g), 10 ) +1;
		  var klon = div.clone().prop('id', 'nouvelleFonction'+num );
		  div.after(klon );
	});

	$('#removeFonction').click(function(e) {
		var div = $('div[id^="nouvelleFonction"]:last');
		var num = parseInt( div.prop("id").match(/\d+/g), 10 );
		if(num == 0){
			return;
		}
		div.remove();
	});

	$('#addNewFonction').click(function(){
		var div = $('div[id^="newFonction"]:last');
		  var num = parseInt( div.prop("id").match(/\d+/g), 10 ) +1;
		  var klon = div.clone().prop('id', 'newFonction'+num );
		  div.after(klon );
	});

	$('#removeLastFonction').click(function(e) {
		var div = $('div[id^="newFonction"]:last');
		var num = parseInt( div.prop("id").match(/\d+/g), 10 );
		if(num == 0){
			return;
		}
		div.remove();
	});

});