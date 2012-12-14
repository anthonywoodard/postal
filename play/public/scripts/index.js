require({
    packages: [
        { name:'bootstrap', location:'http://dojobootstrap.com/js/bootstrap/1.1/'}
    ]
},[
	'dojo/query', 
	'bootstrap/Tab', 
	'postal/zip', 
	'postal/city', 
	'postal/state', 
	'dojo/domReady!'
], function(query){
	query('#postalTabs a').on('click', function (e) {
		e.preventDefault();
		query(this).tab('show');
	});
});
