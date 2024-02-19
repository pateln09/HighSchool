import java.io.*;
import java.util.*;

/*You are in Dallas.Read in this flight data and print out
the minimum cost from Dallas to all these cities */ 

public class DijkstraAlgorithm {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("dataDijkstra.dat"));
		
		int[][] adj = new int [100][100];
		
		Map<String, Integer> map = new HashMap<>();
		
		int index = 0;
		
		int tripsCount = 0;
		while(scan.hasNext()) {
			String left = scan.next();
			String right = scan.next();
			int price = scan.nextInt();
			
			if (!map.containsKey(left))
				map.put(left, index++);
			
			if (!map.containsKey(right))
				map.put(right, index++);
			
			adj[map.get(left)][map.get(right)] = price;
			adj[map.get(right)][map.get(left)] = price;
			
			
			tripsCount++;
		}
		int len = index;
		
		int dis = 0;
		while(tripsCount -- > 0){
			String cityOne = scan.next();
			String cityTwo = scan.next();
			int p = scan.nextInt();
			
			
			dis+=solve(adj, map.get(cityOne), map.get(cityTwo), len, map.get(cityTwo));
		
		}
		System.out.println(dis);
		
		
		
		
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
