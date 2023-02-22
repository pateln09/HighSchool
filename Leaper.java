import java.io.*;
import java.util.*;

public class Leaper {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("leaper.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			int year = scan.nextInt();
			if ((year % 4 == 0) && (year%100 != 0) || (year % 400 == 0))
				System.out.println("Leaper");
			else
				System.out.println("Not a Leaper");
			
		}
	}

}
