import java.io.*;
import java.util.*;


public class Rev {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan =  new Scanner (new File ("rev.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();  
		
		while(noSets -- > 0) {
			String str = scan.nextLine();
			//System.out.println(str);
			int size = (int) Math.ceil(Math.sqrt(str.length()));
			//System.out.println(size);
			
			String arr[][] = new String[size][size];
			
			int len = 0;
			for (int r = size-1; r >= 0; r--) {
				for (int c = 0;  c< arr[0].length; c++) {
					if (len < str.length()) {
						arr[r][c] = str.substring(len, len+1);
						len++;
						//str = str.substring(1);
					}
					else {
						arr[r][c] = "*";
					}
				}
			}
			
			
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
