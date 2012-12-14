using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Mvc.Ajax;

namespace Postal.Controllers
{
	public class DataController : Controller
	{
		public ActionResult Zip (int postalcode)
		{
			PostalCodes pcs = new PostalCodes();
			PostalCode pc = pcs.getCityByZip(postalcode);
			string jsonString = JsonHelper.JsonSerializer<PostalCode>(pc);
			Response.Write(jsonString);
			return null;
		}
		public ActionResult Zips (int qry)
		{
			PostalCodes pcs = new PostalCodes();
			List<int> zipcodes = pcs.getZipcodes(qry);
			string jsonString = JsonHelper.JsonSerializer<List<int>>(zipcodes);
			Response.Write(jsonString);
			return null;
		}
		public ActionResult City (string qry)
		{
			PostalCodes pcs = new PostalCodes();
			List<string> cities = pcs.getCities(qry);
			string jsonString = JsonHelper.JsonSerializer<List<string>>(cities);
			Response.Write(jsonString);
			return null;
		}
		public ActionResult CityStates (string city)
		{
			PostalCodes pcs = new PostalCodes();
			List<string> states = pcs.getStatesByCity(city);
			string jsonString = JsonHelper.JsonSerializer<List<string>>(states);
			Response.Write(jsonString);
			return null;
		}
		public ActionResult States ()
		{
			States sts = new States();
			List<State> states = sts.getAll();
			string jsonString = JsonHelper.JsonSerializer<List<State>>(states);
			Response.Write(jsonString);
			return null;
		}
		public ActionResult State (string state)
		{
			PostalCodes pcs = new PostalCodes();
			List<string> cities = pcs.getCitiesByState(state);
			string jsonString = JsonHelper.JsonSerializer<List<string>>(cities);
			Response.Write(jsonString);
			return null;
		}
	}
}

