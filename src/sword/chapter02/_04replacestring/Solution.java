package sword.chapter02._04replacestring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		//replace " " to %20
		String testStr="we are happy!";
		String replaceStr=testStr.replace(" ","%20");
		System.out.println(replaceStr);
	}
	/*public static String replace(String oldString){
		
	}*/
	
	
/*	  public String replace(CharSequence target, CharSequence replacement) {
		return Pattern.compile(target.toString(), Pattern.LITERAL).matcher(this)
				.replaceAll(Matcher.quoteReplacement(replacement.toString()));
	}*/

}
