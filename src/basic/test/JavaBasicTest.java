package basic.test;

import java.nio.ByteBuffer;

/*Java�и������Ƶı�ʾ. 
 * 
 * */
public class JavaBasicTest {
	public static void main(String[] args) {
		int a = 100; //ʮ����
		System.out.println(a);
		a = 0144; //�˽���
		System.out.println(a);
		a = 0xFF; //ʮ���˽���
		System.out.println(a);
		
		int b = 255; 
		
		//Integer.toHexString
		System.out.println(Integer.toHexString(b));
		
		//ֱ�Ӵ�ӡÿ��byte���ᵼ�´�ӡ��int
		byte[] bytes = ByteBuffer.allocate(4).putInt(b).array();
		for (byte c : bytes) {
			System.out.println( c);
		}
		
		//ÿ��byte��ӡ��ʮ�����Ƹ�ʽ
		for (byte c : bytes) {
		   System.out.format("0x %x ", c);
		}
	}
}
