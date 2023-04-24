import java.io.*;
import java.util.*;



public class ValidParentheses {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("validparentheses.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets-- > 0) {
			Stack <Character> stack = new Stack <Character>();
			
			char arr[] = scan.nextLine().toCharArray();
			
			boolean isValid = true;
			for (char c: arr){				
				if (c == '(' || c == '[' || c == '{')
					stack.push(c);
				
				if (!stack.empty()) {
					if (c == ')') {
						if (stack.peek() != '(')
							isValid = false;
						stack.pop();	
					}
					if (c == ']') {
						if (stack.peek() != '[')
							isValid = false;
						stack.pop();
					}
					if (c == '}') {
						if (stack.peek() != '{')
							isValid = false;
						stack.pop();
					}
					
				}
				
			}
			
			System.out.println(isValid);
			
		}
		
	}

}
