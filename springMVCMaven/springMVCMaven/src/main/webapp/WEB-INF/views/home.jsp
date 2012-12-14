<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Postal</title>        
        <link href="<c:url value="/resources/css/normalize.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <style>
        	body {
        		margin-top: 60px;        		
        	}
        </style>                
        <script src="<c:url value="/resources/scripts/require-min.js"/>"></script>
        <script>
        	requirejs.config = {
        	    baseUrl: '<c:url value="/resources/scripts"/>'
        	};
        	requirejs(['<c:url value="/resources/scripts"/>/lib/jquery-min.js', '<c:url value="/resources/scripts"/>/app/postal.js', '<c:url value="/resources/scripts"/>/lib/bootstrap.min.js'],
      			function($, app) {
      				app.init();
      			});
        </script>
    </head>
    <body>            	
        <div class="navbar navbar-fixed-top nav">
  			<div class="navbar-inner">
    			<a class="brand" href="#">Postal</a>    			
  			</div>
		</div>
		<div class="container">		
			<!--  p>  The time on the server is ${serverTime}. </p-->
			<div class="row">
				<div class="span5">
					<div data-spy="affix" data-offset-top="60">
						<div class="accordion" id="accordion2">
				  			<div class="accordion-group">
				    			<div class="accordion-heading">
				      				<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
				        				City By Zip
				      				</a>
				    			</div>
				    			<div id="collapseOne" class="accordion-body collapse in">
				      				<div class="accordion-inner">
				        				<input id="zip" type="text" placeholder="Enter Zip"/>
										<button id="btnZip" class="btn">Go Get It</button>
				      				</div>
				    			</div>
				  			</div>
				  			<div class="accordion-group">
				    			<div class="accordion-heading">
				      				<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
				        				States By City
				      				</a>
				    			</div>
				    			<div id="collapseTwo" class="accordion-body collapse">
				      				<div class="accordion-inner">
				        				<input id="city" type="text" placeholder="Enter City"/>
										<button id="btnCity" class="btn">Go Get It</button>
				      				</div>
				    			</div>
				  			</div>
				  			<div class="accordion-group">
				    			<div class="accordion-heading">
				      				<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
				        				Cities In State
				      				</a>
				    			</div>
				    			<div id="collapseThree" class="accordion-body collapse">
				      				<div class="accordion-inner">
				        				<select id="state"></select>
										<button id="btnState" class="btn">Go Get It</button>
				      				</div>
				    			</div>
				  			</div>
						</div>	
					</div>
				</div>				
				<div id="resultsContainer" class="span7">	
					<p id="searching">Searching...</p>			
					<table id="table" class="table table-condensed"></table>
				</div>
			</div>	
		</div>		
    </body>
</html>
