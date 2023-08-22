import java.io.*;
import java.util.*;

public class DeshiTwo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("Deshi.dat"));
		
		
			while (scan.hasNext()) {
				String str = scan.nextLine();
				System.out.println((str.matches("(.*[aeiou]){1,4}(.*[^aeiou]){1,7}"))? "ACCEPTABLE": "NOT ACCEPTABLE");
			}
	}

}