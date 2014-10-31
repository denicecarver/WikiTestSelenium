package com.selenium.wikitest.webpage.homepage;

public class Converter {
	private static char hexdigit(int c) {
		String charset = "0123456789ABCDEF";
		return charset.charAt(c & 0x0F);
	}

	private static String buildLiteral(char c) {
		String literal=hexdigit(c >>> 12)+""+ hexdigit(c >>> 8) +""+ hexdigit(c >>> 4) +""+ hexdigit(c);
		return literal;
	}

	public static String Uni2JavaLiteral(String input) {

		String literals = "";

		for (int i=0; i<input.length();i++)
		{
			if (input.charAt(i) == 10) literals += "\\n";
			else if (input.charAt(i) == 13) literals += "\\r";
			else if (input.charAt(i) == 92) literals += "\\\\";
			else if (input.charAt(i) == 34) literals += "\\\"";
			else if (input.charAt(i) == ' ') literals += " ";
			else if (input.charAt(i) < 32 || input.charAt(i) > 126) literals += "\\u" + buildLiteral(input.charAt(i));
			else literals += input.charAt(i);
		}
		return literals;
	}

}
