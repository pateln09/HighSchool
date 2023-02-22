import java.io.*;
import java.util.*;


public class Spiral {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("spiral.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		int spiral = 1;
		
		while (noSets-->0) {
			int size = scan.nextInt();
			int [][] arr = new int [size][size];
			
			int depth = 0;
			int num = 1;
			
			
			for (int i = 0; i < size/2; i++) {
				//left-right
				for (int r = depth; r < arr[0].length-depth; r++) {
					arr[depth][r] = num++;
				}
				//up-down
				for (int d = depth+1; d < arr.length-depth; d++) {
					arr[d][arr.length-1-depth] = num++;
				}
				for (int r = arr[0].length-2-depth; r >= depth; r--) {
					arr[arr.length-1-depth][r] = num++;
				}
				//down-up
				for (int u = arr.length-2-depth; u > depth; u--) {
					arr[u][depth] = num++;
				}
				depth++;
				}
			
			//odd
			int middle = size/2;
			if (arr[middle][middle] == 0)
				arr[middle][middle] = num;
				
			
				
				System.out.println("Spiral #" + spiral);
				spiral++;
				
				for (int row = 0; row < arr.length; row++) {
					for (int col = 0; col < arr[row].length; col++) {
						System.out.printf("%-3s", arr[row][col]);
					}
					System.out.println();
				}
				System.out.println();
				
			}
			
			
		}
	}

