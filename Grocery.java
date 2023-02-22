import java.io.*;
import java.util.*;

public class Grocery {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("grocery.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			int unique_ways = 0;
			int change = scan.nextInt();
			scan.nextLine();
			String arr [] = scan.nextLine().split(" ");
			System.out.println(Arrays.toString(arr));
			
			for (int i = 0; i < arr.length; i++) {
				int change_int = Integer.parseInt(arr[i]);
				
				if (change_int <= change) {
					unique_ways++;
				}
				for (int j = i+1; j < arr.length; j++) {
					if (change_int + Integer.parseInt(arr[j]) < change) {
						unique_ways++;
					}
				}
			}
			System.out.println("Total Number of Distinct Ways to get a change of " + change + ": " + unique_ways);
		}
	}
	
}
