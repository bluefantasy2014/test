package performance.test;

public class OutOfMemoryTest {
	public static void main(String[] args) {
		int size = 2;
		
		try {
		for (int i=0; i<200; ++i){
			System.out.println( i + " round test," + size + "," + Runtime.getRuntime().freeMemory() );
			int[] data = new int[size]; 
			size = size *2; 
		}
		}catch (Throwable t){
			System.out.println( "error catched" ) ; 
			t.printStackTrace();
		}
	}
}
