import java.io.*;
import java.util.*;


public class Revenge {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File ("revenge.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			String str = scan.nextLine();
			
			ArrayList <StringBuilder> list = new ArrayList<>();
			StringBuilder initial = new StringBuilder ();
			initial.append(str);
			list.add(initial);
			
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).length() > 1) {
					for (int j = 0; j < list.size(); j+=2) {
						StringBuilder rev = list.get(j).reverse();
						
						String temp = rev.toString().substring(rev.length()/2);	
						StringBuilder sb = new StringBuilder ();
						sb.append(temp);
						
						String temp2 = rev.toString().substring(0,rev.length()/2);	
						StringBuilder sb2 = new StringBuilder ();
						sb2.append(temp2);
						
						list.set(j, sb2);
						list.add(j+1, sb);
						
					}
				}
				
			}
			
		
			String output = "";
			for (int i = 0; i < list.size(); i++) {
				output+=list.get(i).toString();
			}
			System.out.println(output);
			
				
			}
				
		}
	}


