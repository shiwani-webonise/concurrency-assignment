import java.util.*;

public class Sequential{
	public static int cart_load() {
		return 10;
	}
	public static int cart_unload() {
		return 10;
	}
	public static int incinerator() {
		return 20;
	}
	public static int walk(){
		return 30;
	}

	public static int calculate_remaining_time(int books) {
		int burn_cycles = books/3;
		int total_cycles;
		if (books%3==0)
			total_cycles=burn_cycles;
		else
			total_cycles=burn_cycles+1;
		return total_cycles;
	}

	public static void main(String[] args) {
		int no_books = 50;
		int n = no_books;
		int remaining_books = 0;
		int time_to_burn_remaining =0;
		int total_time = 0;
		int i =1;
		while (n > 0) {
			total_time = total_time + cart_load() + walk() + cart_unload() + walk();
			 remaining_books = 2*i; /*There will be 2 books remaining as gopher carries 5 and at a time burns 3 books*/
			 n = n-5;
			 i++;
		}

		time_to_burn_remaining = calculate_remaining_time(remaining_books) * incinerator();
		total_time += time_to_burn_remaining - 30; /*Subtracting one cycle walk time assuming that gopher never goes back to empty pile 
												  and waits by incinerator*/
		System.out.println("Total time is:" + total_time);
		
	}


}