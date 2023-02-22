import java.io.*;
import java.util.*;

public class Bag {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("bag.dat"));
		
		int noSets = scan.nextInt(); 
		scan.nextLine();
		
		String [] sequence = {"I","T","O","L","J","S","Z"};
		
		while (noSets -- > 0) {
			String[] arr = scan.nextLine().split("");
			
			
			
			boolean valid = true;
			for (int traverse = 0; traverse < arr.length; traverse += 7) {
				
				for (int seq = 0; seq < sequence.length; seq++) {
					for (int pointer = traverse; pointer < traverse + 7 && pointer< arr.length; pointer++) {
						for (int comp = traverse; comp < traverse + 7 && comp <arr.length; comp++) {
							if (comp != pointer  && arr[pointer].equals(sequence[seq]) && arr[comp].equals(sequence[seq]))
								valid = false;
						}
					}
				}
				
			}
			if (valid)
				System.out.println("Valid bag");
			else
				System.out.println("Invalid bad");
			
		}
	}

}
