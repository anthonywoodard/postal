<%@ Control Language="C#" Inherits="System.Web.Mvc.ViewUserControl" %>
				
<div class="tab-pane" id="city-pane">
	<h2>City &rarr; States</h2>
	<label>Enter City</label>
	<input id="city" type="text" data-provide="typeahead" data-items="10" /><span class="help-inline">3 character minimum</span>
	<div id="city_state"></div>
</div>