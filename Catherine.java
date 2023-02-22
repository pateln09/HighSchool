import java.io.*;
import java.util.*;

public class Catherine {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("catherine.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		while(n-- > 0) {
			String word = "";
			String [] arr = scan.nextLine().split(" ");
			String str1 = arr[0];
			String str2 = arr[1];
			for (int i = 0; i < str1.length()-1; i++) {
				int index = str2.indexOf(str1.substring(i,i+1));
				if(index > 0) {
					if (index == i) {
						word += str1.substring(i,i+1).toUpperCase();
					}
					word += str1.substring(i,i+1).toLowerCase();
				}
				else {
					word += "*";
				}
			}
			System.out.println(word);
		}
	}

}
