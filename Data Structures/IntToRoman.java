import java.util.*;


public class IntToRoman {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		
		
		
		
		System.out.println("Enter an integer to convert to Roman numeral: ");
		int intNum = scan.nextInt(); // scanning the integer 
		
		String roman = ""; // string used to store the final Roman numeral 

		
		while (intNum > 0) { // while not all of the digits of the integer have been converted to Roman numeral 
			for (Map.Entry <Integer, String> mp:map.entrySet()) { // looping through the map
				int digit  = intNum/mp.getKey(); // dividing the integer by the key at position (x) in map [this gets the leftmost digit according to its placevalue; i.e 722/500 = 1:("D")] *until a a key goes into intNum > 0 times 
				String value = mp.getValue(); // stores the successful value that fully goes into the integer
				while(digit-->0) { // the times the successful value needs to be printed
					roman+=value;
				}
				intNum = intNum%mp.getKey(); //gives the remaining value and keeps on going until less than 0
				
			}
			
		}
			

		System.out.println(roman); // print the final roman
		scan.close();
	}

}
