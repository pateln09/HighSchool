import java.io.*;
import java.util.*;

public class Records {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("records.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		ArrayList <Storm> list = new ArrayList <>();
		
		//Storing the data in the class Storm
		while (noSets -- > 0) {
			String [] arr = scan.nextLine().split(" ");
			
			String id = arr[0];
			double year = Double.parseDouble(arr[1]);
			String month = arr[2];
			double day = Double.parseDouble(arr[3]);
			String continent = arr[4];
			double rainfall = Double.parseDouble(arr[5]);
			double windspeed = Double.parseDouble(arr[6]);
			list.add(new Storm (id, year, month, day, continent, rainfall, windspeed));
			
			//Comparators (descending order in terms of severity)
			Comparator<Storm> comp1 = (a,b) -> Double.compare(b.windspeed, a.windspeed);
			Comparator<Storm> comp2 = (a,b) -> Double.compare(b.rainfall, a.rainfall);
			Comparator<Storm> comp3 = (a,b) -> (a.id).compareTo(b.id);
			Collections.sort(list, comp1.thenComparing(comp2).thenComparing(comp3));
			
		}
		
		
		int noSets2 = scan.nextInt();
		scan.nextLine();
		
		//Computing the input finder terms
		while (noSets2 -- > 0) {
			
			
			ArrayList <String> input = new ArrayList <String>(); // ArrayList filled with the input finder terms
			String [] arr2 = scan.nextLine().split("=| "); // to scan in the input finder line
			
			ArrayList <String> output = new ArrayList <String>(); // store the ArrayList with the matches from the input finder terms
			
			//Storing the contents the arr2 that has the input finder line to the input ArrayList
			for (int i = 0; i < arr2.length; i+=2) {
				input.add(arr2[i]);
				input.add(arr2[i+1]);
			}

			
			//checking if any of the Storm match the input finder terms
			for (int i = 0; i < list.size(); i++) {
				boolean matches = true;
				for (int j = 0; j < input.size(); j+=2) {
					boolean citeria = contents(list.get(i), input.get(j), input.get(j+1));
					if (citeria == false) {
						matches = false;
						
					}
				}
				if (matches == true)
					output.add(list.get(i).id);
			}
			
			//printing the output
			if (!output.isEmpty()) {
				for (int i = 0; i < output.size(); i++) {
					System.out.print(output.get(i) + " ");
				}
				System.out.println();
			}
			else {
				System.out.println("[no results]");
			}
		}
	}
	

	private static boolean contents(Storm storm, String inp_type, String inp_key) {
		if (inp_type.equals("id")) {
			if (storm.id.equals(inp_key)) {
				return true;
			}
		}
		else if (inp_type.equals("year")) {
			if (storm.year==Double.valueOf(inp_key)) {
				return true;
			}
		}
		else if (inp_type.equals("month")) {
			if (storm.month.equals(inp_key)) {
				return true;
			}
		}
		else if (inp_type.equals("day")) {
			if (storm.day==Double.valueOf(inp_key)) {
				return true;
			}
		}
		else if (inp_type.equals("continent")) {
			if (storm.continent.equals(inp_key)) {
				return true;
			}
		}
		else if (inp_type.equals("rainfall")) {
			if (storm.rainfall==Double.valueOf(inp_key)) {
				return true;
			}
		}
		else if (inp_type.equals("windspeed")) {
			if (storm.windspeed==Double.valueOf(inp_key)) {
				return true;
			}
		}
		return false;
	}
}

	

class Storm{
	String id;
	double year;
	String month;
	double day;
	String continent;
	double rainfall;
	double windspeed;
	public Storm(String id, double year, String month, double day, String continent, double rainfall, double windspeed) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.continent = continent;
		this.rainfall = rainfall;
		this.windspeed = windspeed;
	}
}
