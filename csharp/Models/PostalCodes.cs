using System;
using System.IO;
using System.Data.SqlClient;
using System.Collections.Generic;
using System.Globalization;

namespace Postal
{
	public class PostalCodes
	{

		public PostalCodes ()
		{
		}

		public List<PostalCode> getAll ()
		{
			return execute("");
		}

		public List<int> getZipcodes (int zipcodes=0)
		{
			List<int> zips = new List<int>();
			List<PostalCode> postalcodes = execute("WHERE Zipcode LIKE '" + zipcodes + "%'");
			foreach (PostalCode postalcode in postalcodes) {
				zips.Add(postalcode.zipcode);
			}
			zips.Sort();
			return zips;
		}

		public PostalCode getCityByZip (int zipcode=0)
		{
			PostalCode pc = new PostalCode ();
			List<PostalCode> postalcodes = execute ("WHERE Zipcode = " + zipcode);
			if (postalcodes.Count > 0) {
				pc = postalcodes [0];
			}
			return pc;
		}

		public List<string> getCities (string qry="")
		{
			List<string> cities = new List<string>();
			List<PostalCode> postalcodes = execute("WHERE City LIKE '" + qry + "%'");
			foreach (PostalCode postalcode in postalcodes) {
				if(!cities.Contains(postalcode.city)){
					cities.Add(postalcode.city);
				}
			}
			cities.Sort();
			return cities;
		}

		public List<string> getStatesByCity (string city="")
		{
			List<string> states = new List<string>();
			List<PostalCode> postalcodes = execute("WHERE City = '" + city.ToUpper() + "'");
			foreach (PostalCode postalcode in postalcodes) {
				if(!states.Contains(postalcode.state)){
					states.Add(postalcode.state);
				}
			}
			states.Sort();
			return states;
		}

		public List<string> getCitiesByState (string abbr="")
		{
			List<string> cities = new List<string>();
			List<PostalCode> postalcodes = execute("WHERE abbr = '" + abbr.ToUpper() + "'");
			foreach (PostalCode postalcode in postalcodes) {
				if(!cities.Contains(postalcode.city)){
					cities.Add(postalcode.city);
				}
			}
			cities.Sort();
			return cities;
		}
		
		private List<PostalCode> execute (string sqlwhere)
		{
			List<PostalCode> postalcodes = new List<PostalCode>();
			var connection = DbHelper.GetConnection();
			if (!connection.Equals (null)) {
				using (var cmd = connection.CreateCommand()) {
					connection.Open();
					cmd.CommandText = "SELECT * FROM vw_zipcodes " + sqlwhere;
					using (var reader = cmd.ExecuteReader()) {
						while (reader.Read()) {
							PostalCode pc = new PostalCode();
							pc.zipcode = reader.GetInt32(reader.GetOrdinal("Zipcode"));
							pc.city = StringHelper.ToTitleCase(reader.GetString(reader.GetOrdinal("City")));
							pc.state = reader.GetString(reader.GetOrdinal("State"));
							pc.state_abbr = reader.GetString(reader.GetOrdinal("Abbr"));
							postalcodes.Add(pc);
						}
					}
					connection.Close();
				}
			}
			return postalcodes;
		}
	}
}

