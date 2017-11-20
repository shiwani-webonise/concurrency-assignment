
/* Scenario: One pile of books, one incinerator, one path and two gophers performing load/unload and walk-to/walk-from concurrently after first iteration*/


import java.util.*;
class cart_load_unload extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static int main(String[] args) {
		return 10;
	}
}

class walk extends Thread {
		public void run() {
		try {
				Thread.sleep(3000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

class incinerator extends Thread {
	public void run() {
		try {
				Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static int main(String[] args) {
		return 20;
	}
}

public class Concurrent2 extends Thread{
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		int no_books = 45;
		int i=1;
		int n = no_books;
		int remaining_books = 0;
		int burn_cycles;
		int total_cycles;
	 	while(n > 0){
	 		System.out.println("Hi!");
		 	try{
		 		Thread T1 = new Thread(new cart_load_unload());
	 			Thread T2 = new Thread(new walk());
		 		T1.start();
		 		T1.join();
		 		T2.start();
		 		T2.join();
		 		
		 	}
		 	catch(Exception e){
		 	
		 		System.out.println(e);
		 	}
		 	remaining_books = 2*i;
		 	i++;
		 	n = n - 5;
	 	}
	 	remaining_books += 2;
	 	System.out.println(remaining_books);
	 	if (remaining_books%3==0)
			burn_cycles = remaining_books/3;
		else
			burn_cycles = remaining_books/3 + 1;
	 	while(burn_cycles > 0){
	 		try{
	 			Thread T3 = new Thread(new incinerator());
	 			T3.start();
	 			T3.join();
	 		}
	 		catch(Exception e){
		 	
		 		System.out.println(e);
		 	}
		 	--burn_cycles;
	 	}

	 	final long endTime = System.currentTimeMillis();
	 	System.out.println("Total execution time: " + (endTime - startTime + 5000)/100);
	 }
}
