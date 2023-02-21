import java.io.*;
import java.util.*;

public class pr144 {
	static String [][] arr;
	
	static void newArr (int r , int c) {
		arr = new String[r][c];
	}
	
	static void pr() {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				if (arr[r][c] == null)
					System.out.print("|   |");
				else
					System.out.printf("|%3s|", arr[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void rotRow (int r, int direction) {
		List<String> list = Arrays.asList(arr[r]);
		Collections.rotate(list, direction);
		for (int i = 0; i < arr.length; i++) {
			arr[r][i]= list.get(i);
		}
	}
	
	static void rotCol (int c, int direction) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i][c]);
		}
		Collections.rotate(list, direction);
		for (int i = 0; i < arr.length; i++) {
			arr[i][c] = list.get(i);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr144.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		while (n-->0) {
			String[] str = scan.nextLine().split(" ");
			
			switch(str[0]) {
			case "NEW" -> newArr(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			case "SET" -> arr[Integer.parseInt(str[1])][Integer.parseInt(str[2])] = str[3];
			case "PRINT" -> pr();
			case "ROTATEROW" -> rotRow(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			case "ROTATECOL" -> rotCol(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			}
			
		}
	}
}


	