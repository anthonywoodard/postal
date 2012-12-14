require([
	'dojo/_base/array', 
	'dojo/query', 
	'dojo/on', 
	'dojo/request', 
	'dojo/dom-construct', 
	'bootstrap/Support', 
	'bootstrap/Typeahead', 
	'dojo/NodeList-manipulate', 
	'dojo/domReady!'
], function(array, query, on, request, domConstruct, support){
	var states = [];
	request('/states', {handleAs:'json'}).then(function(data){
		states = data;
		var state_names = array.map(data, function(item){
			return item.state;
		});
		query('#state').typeahead({
		    source: state_names, minLength: 0, items: 50
		});
		query('#state_trigger').on('click', function(){
			query('#state')[0].value = "";
			var typeahead = support.getData('#state', 'typeahead');
			if(typeahead){
				if(typeahead.shown){
					typeahead.hide();
				} else {
					typeahead.query = "";
					typeahead.process(state_names);
				}
			}
		});
	});
	query('#state').on('change', function(){
        query('#state_cities').empty();
		var selected_value = this.value;
        console.log(selected_value);
	    if(selected_value !== ""){
	    	var selected = array.filter(array.map(states, function(item){
	    		return item.state === selected_value ? item.abbr : null;
	    	}), function(item){
	    		return item;
	    	});
	    	if(selected.length > 0){
	            query('#state_cities').text('searching...');
				request('/statecities/'+selected[0], {handleAs:'json'}).then(function (cities) {
		            query('#state_cities').html('<h3>Cities found: '+cities.length+'</h3>');
		            array.forEach(cities, function(city){
		            	domConstruct.place('<span class="label label-warning">'+city+'</li>', query('#state_cities')[0]);
		            });
		        });
	    	}
	    }
	});
	on(query('#state_cities')[0], on.selector('.label', 'click'), function(evt){
		query('#city')[0].value = query(evt.target).text();
		query('#postalTabs a[href="#city-pane"]').tab('show');
		on.emit(query('#city')[0], 'change', { bubbles:false, cancelable:false });
	});
});

