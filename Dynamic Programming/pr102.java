import java.io.*;
import java.util.*;

public class pr102 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr102.dat"));
		
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
			
			if(times == -1) {
				System.out.println("not possible");
			}
			else {
				System.out.println(times);
			}
			
		}
	}

	static int solve(int[] coins, int goalAmount) {
		int dp[] = new int [goalAmount + 1];
		
		dp[0] = 0;
		for (int i = 1; i < goalAmount + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i < goalAmount + 1; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i){
					int temp = dp[i-coins[j]];
					if (temp != Integer.MAX_VALUE && temp + 1 < dp[i])
						dp[i] = temp + 1;
				}
			}
		}
		
		return dp[goalAmount];
		
	}

}
