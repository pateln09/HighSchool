import java.io.*;
import java.util.*;


public class PostfixParser {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("postfix.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			
			String[] str = scan.nextLine().split(" ");
			Stack <Integer> stack = new Stack<>();
			
			
			
			for (int i = 0; i < str.length; i++) {
				
				String s = str[i];
				System.out.println(s);
				if (s.matches("[0-9]+")) {
					int c = Integer.parseInt(s);
					stack.push(c);
				}
				else {
					int num1 = stack.pop();
					int num2 = stack.pop();
					
					switch (s) {
					case "+":
						stack.push(num2 + num2); break;
					case "-":
						stack.push(num2 - num1); break;
					case "/":
						stack.push(num2 / num1); break;
					case "*":
						stack.push(num2 * num1); break;
					}
				}
			}
			System.out.println(stack.pop());
		}
		
		
	}

}
