import java.io.*;
import java.util.*;

public class Hurricane {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("hurricane.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			int wind = scan.nextInt();
			
			if (wind >= 74 && wind <= 95) {
				System.out.println("Category 1");
			}
			else if (wind >= 96 && wind <= 110) {
				System.out.println("Category 2");
			}
			else if (wind >= 111 & wind <= 129) {
				System.out.println("Category 3");
			}
			else if (wind >= 130 && wind <= 156) {
				System.out.println("Category 4");
			}
			else if (wind >= 157) {
				System.out.println("Category 5");
			}
			else {
				System.out.println("Not a hurricane");
			}
		}
	}

}
