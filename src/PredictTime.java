import java.util.Arrays;

public class PredictTime {
	static int accuSize = 0; //累计copy文件大小
	static int accuFileCount = 0;  //累计copy文件个数
	static int accuTime = 0;  //累计copy文件花费时间
	
	static int[] fileSizes = new int[1000]; //文件大小数组 
	static int totalSize = 0; //总文件大小
	
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
		
		//预测速度
		float hisSpeed = (float)accuSize/(float)accuTime; //历史平均速度
		float curSpeed = (float)(fileSizes[accuFileCount-1])/lastFileCost; //当前文件的copy速度
		float skew = (float)totalSize/fileSizes.length; 
		float preSpeed = (hisSpeed+curSpeed)/2; 
		
		return (totalSize-accuSize)/preSpeed; 
	}
}
