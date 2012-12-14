<%@ Page Title="" Language="C#" Inherits="System.Web.Mvc.ViewPage" MasterPageFile="~/Views/Layout.master" %>
<asp:Content ContentPlaceHolderID="head" ID="headContent" runat="server">
	<title>Postal Project</title>
</asp:Content>
<asp:Content ContentPlaceHolderID="main" ID="mainContent" runat="server">
	<div class="row-fluid">
		<div class="span3">
			<div class="well">
				<ul class="nav nav-list" id="postalTabs">
					<li class="active"><a href="#zip-pane">Zip Lookup</a></li>
					<li class=""><a href="#city-pane">City Lookup</a></li>
					<li class=""><a href="#state-pane">State Lookup</a></li>
				</ul>
			</div>
		</div>
		<div class="span9">
			<div class="tab-content">
				<%Html.RenderPartial("ZipCity"); %>
				<%Html.RenderPartial("CityStates"); %>
				<%Html.RenderPartial("StateCities"); %>
			</div>
		</div>
	</div>
</asp:Content>
<asp:Content ContentPlaceHolderID="script" ID="scriptContent" runat="server">
<script type="">
	require({
	    packages: [
	        { name:'postal', location:'/Content/scripts/'}
	    ]
	},['postal/index']);
</script>
</asp:Content>