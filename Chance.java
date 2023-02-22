import java.io.*;
import java.util.*;

public class Chance {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("chance.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		int highest = 0;
		String highest_city = " ";
		
		while (noSets -- > 0) {
			String arr[]= scan.nextLine().split(" ");
			if (Integer.parseInt(arr[1]) > highest) {
				highest = Integer.parseInt(arr[1]);
				highest_city = arr[0];
			}
				
		}
		System.out.println(highest_city);
		
	}

}
