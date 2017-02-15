package basic.test;

import java.nio.ByteBuffer;

/*Java中各个进制的表示. 
 * 
 * */
public class JavaBasicTest {
	public static void main(String[] args) {
		int a = 100; //十进制
		System.out.println(a);
		a = 0144; //八进制
		System.out.println(a);
		a = 0xFF; //十六八进制
		System.out.println(a);
		
		int b = 255; 
		
		//Integer.toHexString
		System.out.println(Integer.toHexString(b));
		
		//直接打印每个byte，会导致打印成int
		byte[] bytes = ByteBuffer.allocate(4).putInt(b).array();
		for (byte c : bytes) {
			System.out.println( c);
		}
		
		//每个byte打印成十六进制格式
		for (byte c : bytes) {
		   System.out.format("0x %x ", c);
		}
	}
}
