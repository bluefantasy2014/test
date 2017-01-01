package jdk.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//REF: http://stackoverflow.com/questions/826212/java-executors-how-to-be-notified-without-blocking-when-a-task-completes


//SOLUTION 1: extends Runnable 
interface MyCallBack {
	public void onComplete(); 
}

class CallbackTask implements Runnable {
	private String name ; 
	private final Runnable task;

	private final MyCallBack callback;

	CallbackTask(String name, Runnable task, MyCallBack callback) {
		this.name = name; 
		this.task = task;
		this.callback = callback;
	}

	public void run() {
		task.run();
		callback.onComplete();
	}
}


public class FutureCallback {
	public static void main(String[] args) {
		CallbackTask task1 = new CallbackTask("task001", new Runnable() {
			@Override
			public void run() {
				System.out.println("I am working on task task001");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("I am done with task task001");
			}
		}, new MyCallBack() {
			@Override
			public void onComplete() {
				System.out.println("Callback of task001");
			}
		});
		
		ExecutorService es = Executors.newFixedThreadPool(2); 
		es.submit(task1); 
	}
}
