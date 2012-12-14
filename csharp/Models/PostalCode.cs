using System;

namespace Postal
{
	public class PostalCode
	{
		public int zipcode { get; set; }
		public string city { get; set; }
		public string state { get; set; }
		public string state_abbr { get; set; }

		public PostalCode ()
		{
		}

		public String toString()
		{
			return this.city + ", " + this.state_abbr + " " + this.zipcode;
		}
	}
}

