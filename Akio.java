import java.io.*;
import java.util.*;

public class Akio {

public static void main(String[] args) throws FileNotFoundException {
Scanner scan = new Scanner(new File("akio.dat"));

int noSets = scan.nextInt();
scan.nextLine();

while (noSets-- > 0) {
ArrayList<Path> map = new ArrayList<>();
char[][] maze = new char[10][10];
boolean visited[][] = new boolean[10][10];

for (int r = 0; r < 10; r++) {
maze[r] = scan.nextLine().toCharArray();
}

for (int r = 0; r < maze.length; r++) {
for (int c = 0; c < maze.length; c++) {
if (r == 0 || r == 9 || c == 0 || c == 9)
if (maze[r][c] == '.'||maze[r][c] == 'o')
map.add(new Path(r, c));
}
} 

int count = Integer.MAX_VALUE;
for (int i = 0; i < map.size(); i++) {
int temp_count = steps(maze, visited, map.get(i).getRow(), map.get(i).getCol());

if (temp_count < count)
count = temp_count;
}

System.out.println(count);
scan.nextLine();

}

}

static int steps(char[][] arr, boolean[][] visited, int x, int y) {

char[][] n_arr = arr.clone();
boolean[][] n_visited = new boolean[arr.length][arr[0].length];
int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
Queue<int[]> line = new LinkedList<>();

line.add(new int[] { x, y, 1 });
n_visited[x][y] = true;
if(arr[x][y]=='o')
return 1;
while (!line.isEmpty()) {
int[] check = line.poll();
for (int i = 0; i < 4; i++) {
int r = check[0] + direction[i][0];
int c = check[1] + direction[i][1];
if (r >= 0 && c >= 0 && r < n_arr.length && c < n_arr[0].length && !n_visited[r][c]
&& n_arr[r][c] != '#') {
if (n_arr[r][c] == 'o') {
return check[2]+1;
}

n_visited[r][c] = true;
line.add(new int[] { r, c, check[2]+1 });
}
}
}

return Integer.MAX_VALUE;
}

}

class Path {
int row;
int col;

public Path(int row, int col) {
super();
this.row = row;
this.col = col;
}

public int getRow() {
return row;
}

public int getCol() {
return col;
}
}