import java.io.*;
import java.util.*;

public class Twister {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File("twister.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			int height = scan.nextInt();
			
			int space = 0;
			for (int i = height; i > 0; i-=2) {
				for (int s = 0; s < space; s++) {
					System.out.print(" "); 
				}
				for (int j = 0; j < i; j++) {
					System.out.print("-");
				}
				System.out.println("");
				space++;
			}
			System.out.println();
		}
	}

}
