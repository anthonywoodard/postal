
﻿
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Postal
{
	public class MvcApplication : System.Web.HttpApplication
	{
		public static void RegisterRoutes (RouteCollection routes)
		{
			routes.IgnoreRoute ("{resource}.axd/{*pathInfo}");

			routes.MapRoute ("zip",
				"zip/{postalcode}",
				new { controller = "Data", action = "Zip", postalcode = 0 }
			);
			routes.MapRoute ("zips",
				"zips/{qry}",
				new { controller = "Data", action = "Zips", qry = 0 }
			);
			routes.MapRoute ("city",
				"city/{qry}",
				new { controller = "Data", action = "City", qry = "" }
			);
			routes.MapRoute ("cities",
				"cities/{qry}",
				new { controller = "Data", action = "City", qry = "" }
			);
			routes.MapRoute ("citystates",
				"citystates/{city}",
				new { controller = "Data", action = "CityStates", city = "" }
			);
			routes.MapRoute ("states",
				"states",
				new { controller = "Data", action = "States" }
			);
			routes.MapRoute ("state",
				"state/{state}",
				new { controller = "Data", action = "State", state = "" }
			);
			routes.MapRoute ("statecities",
			    "statecities/{state}",
				new { controller = "Data", action = "State", state = "" }
			);
			routes.MapRoute ("about",
				"about",
				new { controller = "Home", action = "About" }
			);
			routes.MapRoute ("Default",
			    "{controller}/{action}",
                new { controller = "Home", action = "Index" }
			);
		}

		protected void Application_Start ()
		{
			AreaRegistration.RegisterAllAreas ();
			RegisterRoutes (RouteTable.Routes);
		}
	}
}
