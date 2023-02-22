import java.io.*;
import java.util.*;

public class Vowel {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("vowel.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		String vowels = "[aeiouAEIOU]";
		
		while (noSets -- > 0) {
			String str = scan.nextLine();
			if (str.matches(vowels))
				System.out.println("Vowel!");
			else
				System.out.println("Consonant!");
		}
	}

}
