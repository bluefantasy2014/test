package basic.test;

import java.util.regex.Pattern;

public class SMSTextMatchTest {
	public static void main(String[] args) {
		String smsText = "abc�Ŵ�Ŵ�������sfdas����"; 
		String keyWord = "(����){2}"; 
		int count = 2; 
		
		System.out.println(Pattern.compile(keyWord).matcher(smsText).find());
		
		
	}
	
	/*msg�а���key�Ĵ����� 
	 * */
	public static int matchCount(String msg, String key){
		int count = 0; 
		
		
		return count; 
	}
}
