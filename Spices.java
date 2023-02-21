import java.io.*;
import java.util.*;


public class Spices {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("spices.dat"));
		
		int noSets = scan.nextInt(); //scans the number of data lines there are in the set
		scan.nextLine(); //moving the pointer
		ArrayList<Information> spice = new ArrayList<Information>();
		ArrayList <String> color = new ArrayList (Arrays.asList("White","Red", "Brown", "Orange", "Blue", "Other"));
		while (noSets -- > 0) {
			String arr[] = scan.nextLine().split(" ");
			//getting individual data
			String spice_name = arr[0];
			int spice_amount = Integer.parseInt(arr[1]);
			int spice_uses = Integer.parseInt(arr[2]);
			String spice_color = arr[3];
			spice.add(new Information (spice_name, spice_amount, spice_uses, spice_color));
		}
		
		Comparator<Information> comp1 = (a,b) -> (b.s_uses)-(a.s_uses);
		Comparator<Information> comp2 = (a,b) -> (color.indexOf(a.s_color))-(color.indexOf(b.s_uses));
		Comparator<Information> comp3 = (a,b) -> (a.s_amount)-(b.s_amount);
		Comparator<Information> comp4 = (a,b) -> (a.s_name).compareTo(b.s_name);
		Collections.sort(spice, comp1.thenComparing(comp2).thenComparing(comp3).thenComparing(comp4));
		for (int i = 0; i < spice.size(); i++) {
			System.out.println(spice.get(i).getName());
		}

		
	}

}
class Information{
	String s_name;
	int s_amount;
	int s_uses;
	String s_color;
	public Information(String s_name, int s_amount, int s_uses, String s_color) {
		super();
		this.s_name = s_name;
		this.s_amount = s_amount;
		this.s_uses = s_uses;
		this.s_color = s_color;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return s_name;
	}
	
}
