package lesson4synchronized;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	 private List<Integer> list1 = new ArrayList<Integer>();
	 private List<Integer> list2 = new ArrayList<Integer>();
	 
	 Random random = new Random();

	 
	 public void stageOne() {
		 
		 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		list1.add(random.nextInt(100));
	 }
	 
	 public void stageTwo() {
		
			 try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			 
		list2.add(random.nextInt(100));
	 }
	 
	 public void process() {
		 for (int i = 0; i<=1000; i++) {
			 stageOne();
			 stageTwo();
		 }
	 }
	 
	public void main() {
		
		long start = System.currentTimeMillis();
	
		Thread t1  = new Thread(new Runnable() {
			
			public void run() {
				
				process();
				
			}
		});
		
		t1.start();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken:"+ (end-start));
		System.out.println("List 1 size : "+ list1.size());
		System.out.println(list2.size());
	    
	}

}
