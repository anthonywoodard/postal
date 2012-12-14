using System;

namespace Postal
{
	static public class StringHelper
	{
		public static string ToTitleCase(string s)
		{
			char[] word = new char[s.Length];
			bool newWord = true;
			for (int i = 0; i < s.Length; i++) {
				char c = s[i];
				if(newWord){
					c = Char.ToUpper(c);
					newWord = false;
				} else {
					c = Char.ToLower(c);
				}
				if(c == ' '){ newWord = true; }
				word[i] = c;
			}
			return new string( word );
		}

	}
}

