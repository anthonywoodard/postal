define(function () {	
	return {
		init: function () {
			$('#searching').hide();
			$.getJSON('data/getStates', function(data){
				$.each(data.model, function(){			
					var opt = '<option value="' + this.state + '">' + this.state + '</option>';			
					$('#state').append(opt);
				});		
			});
			$('#btnZip').click(function(){	
				$('#table').empty();
				$('#searching').show();
				$.getJSON('data/zip/' + $('#zip').val() + '/equal', function(data) {
					$('#table').append('<tr><th>City</th><th>State</th></tr>');
					$.each(data, function(){
						var tr = $('<tr></tr>');
						$.each(this, function(){					
							tr.append('<td>' + this.city + '</td>');
							tr.append('<td>' + this.state + '</td>');
						});
						$('#table').append(tr);
					});			
					$('#searching').hide();
				});			
			});
			$('#btnCity').click(function(){
				$('#table').empty();
				$('#searching').show();
				$.getJSON('data/city/' + $('#city').val().toUpperCase() + '/equal', function(data) {
					var lgth = data.model.length;
					if(lgth > 0) {
						var conjugate = 'States';
						if(lgth === 1) {
							conjugate = 'State';
						}
						$('#table').append('<tr><th>' + lgth + ' ' + conjugate + '</th></tr>');
						$.each(data.model, function(){													
							var tr = $('<tr></tr>');										
							tr.append('<td>' + this.state + '</td>');
							$('#table').append(tr);																				
						});				
					} else {
						$('#table').append('<tr><th>No matches found</th></tr>');
					}
					$('#searching').hide();
				});			
			});
			$('#btnState').click(function(){
				$('#table').empty();
				$('#searching').show();
				var si = document.getElementById('state').selectedIndex;
				var opt = $('#state').children()[si];			
				$.getJSON('data/state/' + $(opt).val() + '/equal', function(data) {		
					var lgth = data.model.length;
					if(lgth > 0) {
						var conjugate = 'Cities';
						if(lgth === 1) {
							conjugate = 'City';
						}
						$('#table').append('<tr><th>' + lgth + ' ' + conjugate + '</th></tr>');
						$.each(data.model, function(){													
							var tr = $('<tr></tr>');											
							tr.append('<td>' + this.city + '</td>');
							$('#table').append(tr);																			
						});							
					} else {
						$('#table').append('<tr><th>No matches found</th></tr>');
					}
					$('#searching').hide();			
				});			
			});
			$('#accordion2').on('hide', function () {		
				$('#table').empty();		
			});	
			$('#city').typeahead({
				minLength: 3,
				source: function(a, process){
					$.getJSON('data/city/' + a.toUpperCase() + '/like', function(data){	
						var dataArray = [];
						$.each(data.model, function(){
							dataArray.push(this.city);										
						});							
						process(dataArray);				
					});
				}
			});
			$('#zip').typeahead({
				minLength: 3,
				source: function(a, process){
					$.getJSON('data/zip/' + a + '/like', function(data){
						var dataArray = [];
						$.each(data.model, function(){
							dataArray.push(this.zip);										
						});							
						process(dataArray);
					});
				}
			});
		}
	};
});