using System;
using System.IO;
using System.Configuration;
using System.Data;
using MySql.Data.MySqlClient;
using System.Data.SQLite;

namespace Postal
{
	static public class DbHelper
	{
		public static IDbConnection GetConnection ()
		{
			string dbType = ConfigurationManager.AppSettings ["dbType"];
			if (dbType != null && dbType.Equals ("mysql")) {
				return GetMySQLConnection ();
			} else if (dbType != null && dbType.Equals ("sqlite")) {
				return GetSqliteConnection ();
			} else {
				return null;
			}
		}
		private static IDbConnection GetMySQLConnection ()
		{
			string connectionInfo = ConfigurationManager.AppSettings["mysqlConnectionInfo"];
			IDbConnection dbcon;
			dbcon = new MySqlConnection(connectionInfo);
			return dbcon;
		}
		private static IDbConnection GetSqliteConnection ()
		{
			string connectionInfo = ConfigurationManager.AppSettings["sqliteConnectionInfo"];
			IDbConnection dbcon;
			dbcon = new SQLiteConnection (connectionInfo);
			return dbcon;
		}
	}
}

