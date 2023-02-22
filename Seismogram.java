import java.io.*;
import java.util.*;



public class Seismogram {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("seismogram.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			int row = scan.nextInt();
			int col = scan.nextInt();
			scan.nextLine();
			
			String arr [][] = new String [row][col];
			
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[r].length; c++) {
					arr[r][c] = "O";
					}
				}
	
			// scanning the data
			for (int i = 0; i < row; i++) { 
				arr[i]= scan.nextLine().split("");
			}
				
			
			//finding the split row 
			int split_row = -1;
			
			for (int r = 0; r < arr.length; r++) {
				if (arr[r][0].equals("-")) {
					split_row = r;
					break;
				}
			}
			
						
			//finding the magnitude and index
			
			int magnitude = -1;
			int index = -1;
			
			for (int c = 0; c < arr[split_row].length; c++) {
				int count = 0;
				for (int r = 0; r < split_row; r++) {
					if (c < arr[r].length && arr[r][c].equals("X")) {
						count++;
					}
				}
				if (count > magnitude) {
					magnitude = count; index = c;
				}
			}
			
			for (int c = 0; c < arr[0].length; c++) {
				int count = 0;
				for (int r = split_row+1; r < arr.length; r++) {
					if (c < arr[r].length && arr[r][c].equals("X")) {
						count++;
					}
				}
				if (count > magnitude) {
					magnitude = count; index = c;
				}
				if (count == magnitude && c < index)
					index = c;
			}
			System.out.println("Magnitude: " + magnitude + ", Index: " + (index+1));
		}
	}
}

