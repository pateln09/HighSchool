import java.io.*;
import java.util.*;

public class Silvia2 {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("sofia.dat"));
			
			
			int numFlights = scan.nextInt();
			int cities = scan.nextInt();
			
			int adj [][] = new int [100][100];
			
			Map<String, Integer> map = new HashMap<>();
			
			int index = 0;
			
			while(numFlights-- > 0) {
				String left = scan.next();
				String right = scan.next();
				int price = scan.nextInt();
				
				if (!map.containsKey(left)) {
					map.put(left, index++);
				}
				if (!map.containsKey(right)) {
					map.put(right, index++);
				}
				
				adj[map.get(left)][map.get(right)] = price;
				adj[map.get(right)][map.get(left)] = price;
			}
			
			int len = index;
			while (cities -- > 0) {
				String cityOne = scan.next();
				String cityTwo = scan.next();
				int p = scan.nextInt();
				
				int dylan = solve(adj, map.get(cityOne), map.get(cityTwo), len, map.get(cityTwo));
				if(dylan<=p)
					System.out.println(cityTwo +" is always a good idea.");
				else
					System.out.println("There's no place like home.");
			}
	}
	
	static int solve(int[][] adj, int cityOne, int cityTwo, int len, int goal) {
		int[] distance = new int[len];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[cityOne] = 0;
		boolean [] visited = new boolean[len];
		for (int i = 0; i < len ; i++) {
			int index = helper(distance, visited);
			if (index == -1) {
				return distance[goal];
			}
			visited[index] = true;
			for (int j = 0; j < len; j++) {
				if  (j != cityOne && j != index && adj[index][j] != 0) {
					distance[j] = Math.min(distance[j], distance[index] + adj[index][j]);
				}
			}
		}
		return distance[goal];
		
		
	}
	
	static int helper(int[] distance, boolean [] visited) {
		int ans = -1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < distance.length; i++) {
			if (distance[i]  < min && visited[i] == false) {
				min = distance[i];
				ans = i;
			}
		}
		return ans;
	}
}
