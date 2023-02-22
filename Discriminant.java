import java.io.*;
import java.util.*;

public class Discriminant {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("discriminant.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			double a = scan.nextInt();
			double b = scan.nextInt();
			double c = scan.nextInt();
			
			double discriminant = ((Math.pow(b, 2))-(4*a*c));
		
			if (discriminant > 0) {
				double root_1 = (-1*b)+((Math.sqrt(discriminant))/(2*a));
				double root_2 = (-1*b)-((Math.sqrt(discriminant))/(2*a));
				System.out.printf("Root1 = %.2f and Root2 = %.2f", root_1, root_2);
			}
			else if (discriminant < 0) {
				double front = ((-1*b)/(2*a));
				double root = (Math.sqrt((-1)*((Math.pow(b, 2)-(4*a*c)))))/(2*a);
				System.out.printf("Root1 = %.2f + %.2fi and Root2 = %.2f - %.2fi", front, root, front, root);
			}
			else {
				double root = (-1*b)/(2*a);
				if (root == -0.00)
					root = 0.00;
				System.out.printf("Root1 = %.2f" , root);
			}
			System.out.println();
		}
	}

}
