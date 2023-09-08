import java.io.*;
import java.util.*;






public class Logan {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("logan.dat"));
		
		int noSets = scan.nextInt();
		
		while (noSets -- > 0) {
			int weightCapacity = scan.nextInt();
			int colorInt = scan.nextInt();
			scan.nextLine();
			ArrayList<String>color = new ArrayList <String>();
			
			int[][] arr = new int[colorInt + 1][weightCapacity + 1];
			
			int startRow = 0;
			
			int times = 0;
			
			ArrayList <Integer> weightsList = new ArrayList <Integer>();
			ArrayList <Integer> valueList = new ArrayList <Integer>();
			
			while (times < colorInt) {
                                                                                                                                                                                                                                  				String[] str = scan.nextLine().split(" ");
				int value = Integer.parseInt(str[0]);
				int weightBag = Integer.parseInt(str[1]);
				
				weightsList.add(weightBag);
				valueList.add(value);
				color.add(str[2]);				
				
				fillArray(arr, value, weightBag, ++startRow);
				
				times++;
				
			}
			
			calculate(arr, weightsList, valueList,weightsList);
			print(arr);
		}
	}

	static void calculate(int[][] arr, ArrayList<Integer> weightsList, ArrayList<Integer> valueList,
			ArrayList<Integer> weightsList2) {
		int totalValue = 0;
		int totalWeight = 0;
		
		int r = arr.length-1;
		int c = arr[0].length-1;
		
		System.out.println(r + " " + c);
		
		
		for (int i = weightsList.size(); i > 0; i--) {
			if ( arr[r-1][c-valueList.get(i)] == 0) {
				break;
			}
			if (arr[r][c] != arr[r-1][c-valueList.get(i)]) {
				totalValue+=valueList.get(i);
				totalWeight+=weightsList.get(i);

				
			}
			r = r-1;
			c = c-valueList.get(i);
		}
		System.out.println(totalWeight);
		System.out.println(totalValue);
		
	}

	static void print(int[][] arr) {
		for (int r = 0; r < arr.length; r++){
			for (int c = 0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
	}

	static void fillArray(int[][] arr, int value, int weightBag, int row) {
		for (int r = row; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				
				if (c>=weightBag) {
					if (value + arr[r-1][c-weightBag] > arr[r-1][c]) {
						arr[r][c] = value + arr[r-1][c-weightBag];
					}
					else {
						arr[r][c] = arr[r-1][c];
					}
				}
			}
		}
		
	}
	
	

}
