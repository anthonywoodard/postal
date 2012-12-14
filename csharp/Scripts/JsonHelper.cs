using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.IO;
using System.Text;  
using Newtonsoft.Json;

namespace Postal
{
	/// <summary>
	/// JSON Serialization and Deserialization Assistant Class
	/// </summary>
	public class JsonHelper
	{
		/// <summary>
		/// JSON Serialization
		/// </summary>
		public static string JsonSerializer<T> (T t)
		{
			return JsonConvert.SerializeObject(t);
		}  
		/// <summary>
		/// JSON Deserialization
		/// </summary>
		public static T JsonDeserialize<T> (string jsonString)
		{
			return JsonConvert.DeserializeObject<T>(jsonString);
		}
	}
}