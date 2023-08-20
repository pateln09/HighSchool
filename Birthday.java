import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;



public class Birthday {
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner scan = new Scanner (new File("birthday"));
        
    	ArrayList <String> days = new ArrayList<String>(List .of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")); 
    	
    	ArrayList <Order> list = new ArrayList<Order>();
    	
    	
    	ArrayList<String> nameList = new ArrayList <String>();
    	ArrayList<String> dayWeek = new ArrayList <String>();
    	ArrayList<String> fBday = new ArrayList <String>();
    	
    	while (scan.hasNext()) {
    		String arr [] = scan.nextLine().split(" ");
    		String birthday = arr[1] +"/" + arr[2] + "/" + arr[3];
    		
    		nameList.add(arr[0]);
    		
    		SimpleDateFormat input = new SimpleDateFormat ("yyyy/MM/dd");
    		
    		String formattedbday = "";
    		String dayofweek = "";
    		
    		
    		try {
				Date bday = input.parse(birthday);
				SimpleDateFormat output = new SimpleDateFormat ("EEEE, MMMM d, yyyy");
				formattedbday = output.format(bday);
				
				SimpleDateFormat dayOWeek = new SimpleDateFormat ("EEEE");
				dayofweek = dayOWeek.format(bday);		
				
			} catch (ParseException e) {
				System.out.println("Error");;
			}
    		
    		dayWeek.add(dayofweek);
    		fBday.add(formattedbday);
    		//System.out.println(days.indexOf(dayofweek));
    		
    		
    	}
    	
    	
    	
    	for (int i = 0; i < nameList.size(); i++) {
			Order order1 = new Order(nameList.get(i),dayWeek.get(i),fBday.get(i)); // creating a object (Order) of all of the info collected
			list.add(order1); // adding the object into ArrayList: list
			Comparator<Order> comp1 = (a,b)-> Integer.compare(days.indexOf(a.day), days.indexOf(b.day));// comparing the day of different birthday
			Comparator<Order> comp2 = (a,b)-> a.name.compareTo(b.name); // comparing the name of the people
			
			list.sort(comp1.thenComparing(comp2)); // first sorting the ArrayList: list, by day and then name
		}
		
		//PRINTING THE FINAL OUTPUT
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-12s%s%s", list.get(i).getName(), ": ",list.get(i).getDate()); // formatting the output to print
			System.out.println(); // going to next line "enter"
		}
    }
}

class Order{
	String name;
	String day;
	String wholebday;
	
	public Order(String name, String day, String wholebday) {
		this.name = name;
		this.day = day;
		this.wholebday = wholebday;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String getDate() {
		// TODO Auto-generated method stub
		return wholebday;
	}
	

}