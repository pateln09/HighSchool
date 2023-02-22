import java.io.*;
import java.util.*;

public class Emoji {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("emoji.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		HashMap <String, String> map = new HashMap <String, String>();
		map.put(":D", "smile");
		map.put("=/", "mad");
		map.put(":`(", "cry");
		map.put("*<:o)", "clown");
		map.put("O.o", "confused");
		map.put("B-)", "cool");
		map.put("*-*", "dazed");
		map.put("<3", "heart");
		String punct = ".!";
		while (noSets-- > 0) {
			String [] arr = scan.nextLine().split(" ");
			for (int i = 0; i < arr.length; i++) {
				String temp = "";
				if (punct.indexOf(arr[i].substring(arr[i].length()-1)) != -1){
					temp = arr[i].substring(arr[i].length()-1); 
					arr[i]= arr[i].substring(0, arr[i].length()-1);
					}
				if (map.containsKey(arr[i]))
					arr[i] = map.get(arr[i]);
				else if (map.containsValue(arr[i])) {
					for (Map.Entry<String, String> find: map.entrySet()) {
						if (find.getValue().equals(arr[i]))
							arr[i]= find.getKey();
					}
				}
				if (!temp.equals(""))
					arr[i]= arr[i] + temp;
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	 
	}

}


