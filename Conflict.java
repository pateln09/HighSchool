import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Conflict {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("conflict.dat"));
		
		int noSets= scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			String arr [] = scan.nextLine().split("/| ");
			LocalDate date = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			System.out.println( (date.plusDays(Integer.parseInt(arr[3]))).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) );
		}
	}

}
