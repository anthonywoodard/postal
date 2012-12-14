require([
	'dojo/_base/array', 
	'dojo/query', 
	'dojo/on', 
	'dojo/request', 
	'dojo/dom-construct', 
	'dojo/NodeList-manipulate', 
	'bootstrap/Typeahead', 
	'dojo/domReady!'
], function(array, query, on, request, domConstruct){
	query('#city').typeahead({
	    minLength: 3, items: 15,
	    source: function (query, process) {
	        return request('/cities/'+query, {handleAs:'json'}).then(function (data) {
	            process(data);
	        });
        }
	});
	query('#city').on('change', function(){
        query('#city_state').empty();
		if(this.value !== ""){
            query('#city_state').text('searching...');
			request('/citystates/'+this.value, {handleAs:'json'}).then(function (states) {
	            query('#city_state').html('<h3>States found: '+states.length+'</h3>');
	            array.forEach(states, function(state){
	            	domConstruct.place('<span class="label label-info">'+state+'</li>', query('#city_state')[0]);
	            });
	        });
		}
	});
	on(query('#city_state')[0], on.selector('.label', 'click'), function(evt){
		query('#state')[0].value = query(evt.target).text();
		query('#postalTabs a[href="#state-pane"]').tab('show');
		on.emit(query('#state')[0], 'change', { bubbles:false, cancelable:false });
	});

});

