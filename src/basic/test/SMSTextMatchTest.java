package basic.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMSTextMatchTest {
	public static void main(String[] args) {
		String smsText = "abc放大放大贷款贷款sfdas贷款"; 
		String keyWord = "(贷款){2}"; 
		int count = 2; 
		
		System.out.println(Pattern.compile(keyWord).matcher(smsText).find());
		
		System.out.println(matchCount(smsText,"贷款")); 
	}
	
	/*msg中包含key的次数。 
	 * */
	public static int matchCount(String msg, String key){
		int count = 0; 
		
		Matcher matcher = Pattern.compile(key).matcher(msg); 
		
		while (matcher.find()){
			count++;
		}
		
		return count; 
	}
}
