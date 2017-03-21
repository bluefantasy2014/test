import java.util.Arrays;

public class PredictTime {
	static int accuSize = 0; //�ۼ�copy�ļ���С
	static int accuFileCount = 0;  //�ۼ�copy�ļ�����
	static int accuTime = 0;  //�ۼ�copy�ļ�����ʱ��
	
	static int[] fileSizes = new int[1000]; //�ļ���С���� 
	static int totalSize = 0; //���ļ���С
	
	public static void main(String[] args) {
		
		for (int i=0; i<fileSizes.length; ++i){
			fileSizes[i] = (int)(Math.random()*100); 
		}
		
		totalSize = Arrays.stream(fileSizes).sum(); 
		for (int i=0; i<fileSizes.length; ++i){
			float time = (float)(Math.random()*fileSizes[i]*1000); 
			System.out.println("time spent for " + i + "file:" + time);
			System.out.println(predict(time));
		}
	}
	
	static float predict (float lastFileCost){
		accuSize += fileSizes[accuFileCount++]; 
		accuTime += lastFileCost; 
		
		//Ԥ���ٶ�
		float hisSpeed = (float)accuSize/(float)accuTime; //��ʷƽ���ٶ�
		float curSpeed = (float)(fileSizes[accuFileCount-1])/lastFileCost; //��ǰ�ļ���copy�ٶ�
		float skew = (float)totalSize/fileSizes.length; 
		float preSpeed = (hisSpeed+curSpeed)/2; 
		
		return (totalSize-accuSize)/preSpeed; 
	}
}
