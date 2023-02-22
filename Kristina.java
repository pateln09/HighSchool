import java.io.*;
import java.util.*;

public class Kristina {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("kristina.dat"));
		int n =  scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0) {
			String arr[]= scan.nextLine().split(" ");
			
			//prefix
			if (arr[0].equals("PRE")) {
				Stack<Integer> stack = new Stack<>();
				String operator = "-+*/^";
				for (int i = arr.length-1; i >= 1; i--) {
					if (operator.contains(arr[i])) {
						int a = stack.pop();
						int b = stack.pop();
						if (arr[i].equals("+")) {
							int c = a+b;
							c = stack.push(c);
						}
						if (arr[i].equals("-")) {
							int c = a-b;
							c = stack.push(c);
						}
						if (arr[i].equals("*")) {
							int c = a*b;
							c = stack.push(c);
						}
						if (arr[i].equals("/")) {
							int c = a/b;
							c = stack.push(c);
						}
						if (arr[i].equals("^")) {
							int c = (int) (Math.pow(a, b));
							c = stack.push(c);
						}
					}
					else {
						stack.push(Integer.parseInt(arr[i]));
					}
				}
				System.out.println(stack.peek());
			}
			//post fix
			if (arr[0].equals("POST")) {
				Stack<Integer> stack = new Stack<>();
				String operator = "-+*/^";
				for (int i = 1; i < arr.length; i++) {
					if (operator.contains(arr[i])) {
						int a = stack.pop();
						int b = stack.pop();
						if (arr[i].equals("+")) {
							int c = a+b;
							c = stack.push(c);
						}
						if (arr[i].equals("-")) {
							int c = b-a;
							c = stack.push(c);
						}
						if (arr[i].equals("*")) {
							int c = a*b;
							c = stack.push(c);
						}
						if (arr[i].equals("/")) {
							int c = b/a;
							c = stack.push(c);
						}
						if (arr[i].equals("^")) {
							int c = (int) (Math.pow(a, b));
							c = stack.push(c);
						}
					}
					else {
						stack.push(Integer.parseInt(arr[i]));
					}
				}
				System.out.println(stack.peek());
			}
			
		}
	}

}
