using System;

namespace Postal
{
	public class State
	{
		public string state { get; set; }
		public string state_abbr { get; set; }

		public State ()
		{
		}

		public String toString()
		{
			return this.state + " - " + this.state_abbr;
		}
	}
}

