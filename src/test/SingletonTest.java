package test;

public class SingletonTest {
	
	private static class PlaceHolder{
		private static final SingletonTest instance = new SingletonTest(); 
	}
	
	public SingletonTest getInstance(){
		return PlaceHolder.instance; 
	}
}
