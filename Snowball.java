import java.io.*;
import java.util.*;


public class Snowball {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("snowball.dat"));
		
		String arr [] = scan.nextLine().split(" ");
		
		ArrayList <String> names = new ArrayList <String>();
		
		for (int i = 0; i < arr.length; i++) {
			names.add(arr[i]);
		}
		Collections.sort(names);

		
		int noSets = scan.nextInt();
		scan.nextLine();

		
		while (noSets -- > 0) {
			String hit = scan.nextLine();
			
			String arr2 [] = ((scan.nextLine() + " " + scan.nextLine()).split(" "));
			ArrayList <String> innocents = new ArrayList <String>();
			
			for (int i = 0; i < arr2.length; i++) {
				innocents.add(arr2[i]);
			}
			
			
			String accused = "";
			for (int i = 0; i < names.size(); i++) {
				if (!names.get(i).equals(hit) && innocents.contains(names.get(i)) == false) {
					accused += names.get(i) + " or ";
				}
			}
			accused = accused.substring(0, accused.length()-4);
			System.out.println(accused);
		}
	}

}
