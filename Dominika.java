import java.io.*;
import java.util.*;

public class Dominika {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("dominika.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		int testCase = 0;
		
		while(noSets -- > 0) {
			testCase++;
			
			double x1 = scan.nextDouble();
			double y1 = scan.nextDouble();
			double x2 = scan.nextDouble();
			double y2 = scan.nextDouble();
						
			double midX = (x1 + x2) / 2.0;
	        double midY = (y1 + y2) / 2.0;
			
			
	        double point1X = midX + (y2 - y1) * Math.sqrt(3) / 2.0;
	        double point1Y = midY - (x2 - x1) * Math.sqrt(3) / 2.0;
	        
	        double point2X = midX - (y2 - y1) * Math.sqrt(3) / 2.0;
	        double point2Y = midY + (x2 - x1) * Math.sqrt(3) / 2.0;
	        
	        System.out.println("Test Case: " + testCase);
	        
	        if (point1X < point2X) {
	        	System.out.printf("(%.2f,%.2f)", point1X,point1Y);
	        	System.out.println();
	        	System.out.printf("(%.2f,%.2f)", point2X,point2Y);
	        }
	        else if (point2X < point1X) {
	        	System.out.printf("(%.2f,%.2f)", point2X,point2Y);
	        	System.out.println();
	        	System.out.printf("(%.2f,%.2f)", point1X,point1Y);
	        }
	        else {
	        	if (point1Y < point2Y) {
		        	System.out.printf("(%.2f,%.2f)", point1X,point1Y);
		        	System.out.println();
		        	System.out.printf("(%.2f,%.2f)", point2X,point2Y);
		        }
	        	else if (point2Y <= point1Y) {
	        		System.out.printf("(%.2f,%.2f)", point2X,point2Y);
	        		System.out.println();
	        		System.out.printf("(%.2f,%.2f)", point2X,point2Y);
		        }
	        }
	        System.out.println();
			
			
		}
	}

}
