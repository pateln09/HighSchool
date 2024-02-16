import java.io.*;
import java.util.*;

public class Donghai {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File ("donghai.dat"));

        int noSets = scan.nextInt();
        scan.nextLine();
        
        while (noSets -- > 0) {
        	char [] tempStr = scan.nextLine().toCharArray();
        	
        	ArrayList <Character> list = new ArrayList<>();
        	
        	for (int i = 0; i < tempStr.length; i++) {
        		list.add(Character.toUpperCase(tempStr[i]));
        	}
        	
        	
        	for (int i = 0; i < 26; i++) {
        		int count = Collections.frequency(list, (char)(i+65));
        		
        		if (count > 0)
        			System.out.println((char)(i+65) + " : " + count);
        	}
        	
        	System.out.println("=========");
        	
        }
        
        
    }
}