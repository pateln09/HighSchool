import java.io.*;
import java.util.*;

public class pr130 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr130.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		Map <String, Integer> map = new HashMap<>();
		int[][] adj = new int [10][10];
		int index = 0;
		
		while (noSets -- > 0) {
			String left = scan.next();
			String right = scan.next();
			if(!map.containsKey(left)) {
				map.put(left,index++);
			}
			if (!map.containsKey(right)) {
				map.put(right, index++);
			}
			adj[map.get(left)][map.get(right)] = 1;
			adj[map.get(right)][map.get(left)] = 1;
			
			
		}
		
		noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets -- > 0) {
			String [] arr = scan.nextLine().split("\\s+");
			int ans = solve(adj, map.get(arr[0]),map.get(arr[1]));
			System.out.println(ans);
		}
	}

	static int solve(int[][] adj, Integer start, Integer end) {
		int ans = 0;
		boolean visited [] = new boolean[adj.length];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start,0});
		visited [start] = true;
		while(!queue.isEmpty()) {
			int[] check = queue.poll();
			if (check[0] == end)
				return check[1];
			for (int i = 0; i< adj.length; i++) {
				if (adj[check[0]][i] == 1 && !visited[i]) {
					queue.add(new int[] {i, check[1]+1});
				visited[i] = true;
				}
			}
				
				
		}
		return ans;
	}

}
