import java.io.*;
import java.util.*;

public class Lines {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("lines.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			System.out.println(scan.nextInt() + " lines were sent");
		}
	}

}
