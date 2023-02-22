import java.io.*;
import java.util.*;

public class Product {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("product.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			String arr[] = scan.nextLine().split(" ");
			
			ArrayList <Integer> list = new ArrayList <Integer>();
			for (int i = 0; i < arr.length; i++) {
				ArrayList <Integer> temp_list = new ArrayList <Integer>();
				for (int j = 0; j < arr.length; j++) {
					if (j != i) {
						temp_list.add(Integer.parseInt(arr[j]));
					}
				}
				int products = temp_list.get(0);
				for (int k = 1; k < temp_list.size(); k++) {
					products *= temp_list.get(k);
				}
				list.add(products);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}
