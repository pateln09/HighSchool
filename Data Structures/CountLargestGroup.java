import java.util.*;



public class CountLargestGroup {
	
	static int countSum (int n) {
		int sum = 0;
		while (n > 0) {
			sum +=n%10;
			n /= 10;
		}
		return sum;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter an integer: ");
		int n = scan.nextInt();
		
		Map <Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int maxGroup = 0;
		
		for (int i = 1; i <= n; i++) {
			int sum = countSum(i);
			map.put(sum,map.getOrDefault(sum, 0) +1);
			maxGroup = Math.max(map.get(sum), maxGroup);
		}
		
		int maxGroupCount = 0;
		for (int key: map.keySet()) {
			if (map.get(key) == maxGroup)
				maxGroupCount++;
			
		}
		
		
		System.out.println(maxGroupCount);
		scan.close();
	}

}
