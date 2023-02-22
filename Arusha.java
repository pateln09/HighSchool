import java.io.*;
import java.util.*;

public class Arusha {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File ("arusha.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0) {
			String str = "";
			String [] arr = scan.nextLine().split(" ");
			int flip = arr[1].length();
			int len = 0;
			while (flip-- > 0) {
				if(arr[1].substring(len,len+1).equals("L")){
					str = arr[0].substring(1) + arr[0].substring(0,1);
				}
				if(arr[1].substring(len,len+1).equals("R")){
					str = arr[0].substring(arr[0].length()-1) + arr[0].substring(0, arr[0].length()-1);
				}
				len++;
			}
			System.out.println(str);
		}
		
		
	}

}
