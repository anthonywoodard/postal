<#import "layout.ftl" as layout>
<@layout.defaultLayout>
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
            <#include "inc_zipCity.ftl"/>
            <#include "inc_cityStates.ftl"/>
            <#include "inc_stateCities.ftl"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    require({
        packages: [
            { name:'postal', location:'${req.getContextPath()}/resources/scripts'}
        ]
    },['postal/index']);
</script>
</@layout.defaultLayout>
