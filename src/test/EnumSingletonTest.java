package test;

enum Singleton{
	INSTANCE(1,"adafa"); 
	
	private Singleton(int no, String name) {
        this.no = no; 
        this.name = name; 
    }
	
	public void init(String name){
		this.name = name; 
	}
	
	public int no; 
	public String name; 
}

public class EnumSingletonTest {
	public static void main(String[] args) {
		Singleton.INSTANCE.no = 2; 
		Singleton.INSTANCE.init("test");
		System.out.println(Singleton.INSTANCE.no + "," + Singleton.INSTANCE.name);
	}
}
