import java.io.*;
import java.util.*;

public class pr103 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr103.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			int goalAmount = scan.nextInt();
			int coinCount = scan.nextInt();
			
			int coins[] = new int [coinCount];
			for (int i = 0; i < coinCount; i++) {
				coins[i] = scan.nextInt();
			}
			
			int times = solve(coins, goalAmount);
			
			System.out.println(times);
			
		}
	}

	static int solve(int[] coins, int goalAmount) {
		int [] ways = new int [goalAmount + 1];
		
		ways[0] = 1;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < ways.length; j++) {
				if (coins[i] <= j){
					ways[j] += ways[j-coins[i]];
				}
			}
		}
		
	
		return ways[goalAmount];
		
	}

}

