import java.io.*;
import java.util.*;

public class Squall {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("squall.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			System.out.println((int)((1.0*scan.nextInt()/scan.nextInt())*60));
		}
		
	}

}
