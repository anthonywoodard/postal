require({
    packages: [
        { name:'bootstrap', location:'http://dojobootstrap.com/js/bootstrap/1.1/'}
    ]
},[
	'dojo/query', 
	'dojo/on', 
	'dojo/request', 
	'bootstrap/Support', 
	'bootstrap/Typeahead', 
	'dojo/NodeList-manipulate', 
	'dojo/domReady!'
], function(query, on, request, support){
	query('#zipcode').typeahead({
	    minLength: 3, items: 10,
	    source: function (query, process) {
	        return request('/zips/'+query, {handleAs:'json'}).then(function (data) {
	            process(data);
	        });
        }
	});
	query('#zipcode').on('change', function(){
		if(this.value !== ""){
			request('/zip/'+this.value, {handleAs:'json'}).then(function (data) {
	            query('#zipcode_citystate').html('<span class="city">'+data.city+'</span>, <span data-state="'+data.state+'" class="state">'+data.state_abbr+'</span>');
	        });
		}
	});
	on(query('#zipcode_citystate')[0], on.selector('.city', 'click'), function(evt){
		query('#city')[0].value = query(evt.target).text();
		query('#postalTabs a[href="#city-pane"]').tab('show');
		on.emit(query('#city')[0], 'change', { bubbles:false, cancelable:false });
	});
	on(query('#zipcode_citystate')[0], on.selector('.state', 'click'), function(evt){
		query('#state')[0].value = support.getData(evt.target, 'state');
		query('#postalTabs a[href="#state-pane"]').tab('show');
		on.emit(query('#state')[0], 'change', { bubbles:false, cancelable:false });
	});
});

