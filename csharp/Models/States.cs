using System;
using System.IO;
using System.Data.SqlClient;
using System.Collections.Generic;
using System.Globalization;

namespace Postal
{
	public class States
	{

		public States ()
		{
		}

		public List<State> getAll ()
		{
			return execute("");
		}

		private List<State> execute (string sqlwhere)
		{
			List<State> states = new List<State>();
			var connection = DbHelper.GetConnection();
			if (!connection.Equals (null)) {
				using (var cmd = connection.CreateCommand()) {
					connection.Open();
					cmd.CommandText = "SELECT * FROM states " + sqlwhere;
					using (var reader = cmd.ExecuteReader()) {
						while (reader.Read()) {
							State st = new State();
							st.state = reader.GetString(reader.GetOrdinal("State"));
							st.state_abbr = reader.GetString(reader.GetOrdinal("Abbr"));
							states.Add(st);
						}
					}
					connection.Close();
				}
			}
			return states;
		}
			
	}
}

