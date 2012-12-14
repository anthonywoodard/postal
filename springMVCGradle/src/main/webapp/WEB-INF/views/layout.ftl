<#macro defaultLayout>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${req.getContextPath()}/resources/styles/bootstrap.min.css"/>
    <link rel="stylesheet" href="${req.getContextPath()}/resources/styles/styles.css"/>
    <script src="${req.getContextPath()}/resources/scripts/config.js"></script>
    <script src="http://mpagesmock01/cdn/libs/dojo/1.8.0/sdk/dojo/dojo.js"></script>
    <title>${title}</title>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/">Postal Project</a>
            <ul class="nav">
                <#if menu = 1>
                <li class="active"><a href="/index.html">Home</a></li>
                <#else>
                <li><a href="/index.html">Home</a></li>
                </#if>
                <#if menu == 2>
                <li class="active"><a href="/about.html">About</a></li>
                <#else>
                <li><a href="/about.html">About</a></li>
                </#if>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <#nested/>
</div>
</body>
</html>
</#macro>
