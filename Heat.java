import java.io.*;
import java.util.*;

public class Heat {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("heat.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();;
		
		while (noSets -- > 0) {
			String arr[] = scan.nextLine().split(" ");
			String direction = "";
			
			int single_highest = Find_single_highest(arr);
			if (single_highest != -1) {
				direction = Find_direction(single_highest);
				System.out.println(direction);
			}
			else {
				String two_highest = Find_two_highest(arr);
				direction = Find_direction(Integer.parseInt(two_highest.substring(0, 1))) + " " + Find_direction(Integer.parseInt(two_highest.substring(1)));
				System.out.println(direction);
				
			}
		}
	}

	static String Find_two_highest(String[] arr) {
		int first_highest = Integer.parseInt(arr[0]);
		int first_highest_spot = 0;
		for (int i = 0; i < arr.length/2; i++) {
			if (Integer.parseInt(arr[i]) > first_highest) {
				first_highest = Integer.parseInt(arr[i]);
				first_highest_spot = i;
			}
		}
		
		int second_highest = Integer.parseInt(arr[2]);
		int second_highest_spot = 2;
		for (int i = 2; i < arr.length; i++) {
				if (Integer.parseInt(arr[i]) > second_highest) {
					second_highest = Integer.parseInt(arr[i]);
					second_highest_spot = i;
				}
		}
		return first_highest_spot + "" + second_highest_spot; 
		
	}

	static String Find_direction(int highest) {
		if (highest == 0)
			return "North";
		if (highest == 1)
			return "South";
		if (highest == 2)
			return "West";
		return "East";
	}

	static int Find_single_highest(String[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			int num = Integer.parseInt(arr[i]);
			for (int j = 0; j < arr.length; j++) {
				if (Integer.parseInt(arr[j]) == num)
					count++;
			}
			if (count == 3) 
				break;
		}
		int highest_spot = -1;
		int highest_num = Integer.parseInt(arr[0]);
		for (int i = 0; i < arr.length; i++) {
			if (Integer.parseInt(arr[i]) >  highest_num) {
				highest_num = Integer.parseInt(arr[i]);
				highest_spot = i;
			}
		}
		return highest_spot;
		
		
	}

}
