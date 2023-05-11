import java.io.*;
import java.util.*;

public class Permutation {

	static void recurv(int arr[], int index, List<List<Integer>>list) {
		List<Integer> permu = new ArrayList<>();
		
		if(arr.length == index) {
			for (int num: arr) {
				permu.add(num);
			}
			list.add(permu);
			return;
		}
		
		for (int i = index; i < arr.length;i++) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			recurv(arr,index+1,list);
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		List<List<Integer>> list = new ArrayList<>();
		
		
		System.out.println("Enter an array to permutate:");
		String str = scan.nextLine();
		str = str.substring(1,str.length()-1);
		
		String arr[] = str.split(",");
		
		
		
		int [] tempList= new int [arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			tempList[i] = Integer.parseInt(arr[i]);
		}
		
	
		recurv(tempList, 0, list);
		
		System.out.println(list);
		
		
		
		scan.close();
		
	}

}
