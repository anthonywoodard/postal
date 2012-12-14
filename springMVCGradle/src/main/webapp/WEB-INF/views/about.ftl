<#import "layout.ftl" as layout>
<@layout.defaultLayout>
<h2>Project Overview:</h2>
    <p>Create a simple restful service that returns data in JSON format. (bonus if the format can be returned based on the extension provided in the request. i.e. person.xml or person.json). The service should have two controllers: Home and Data.
        <br/>The Home Controller should have:
    <ul>
        <li>default home page with a form for calling the data services. The page should be able to demonstrate each of the data services listed below.</li>
        <li>about page with whatever you like. No other purpose other than having two pages with shared layout and different content</li>
    </ul>
    <br/>The Data Controller should provide the restful data. The data should be:
    <ul>
        <li>Zip action for returning the city and state based on the provided zipcode</li>
        <li>City action for returning a list of cities to fill an autocomplete</li>
        <li>States action for returning a list of states a city exists in</li>
        <li>State action for returning a list of cities for a given state abbreviation (the implementing page can provide a dropdown list of states and pass an abbreviation to the service)</li>
    </ul>
    </p>
</@layout.defaultLayout>