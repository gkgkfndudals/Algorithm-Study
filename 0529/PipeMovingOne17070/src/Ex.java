import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex {
	private static int[] di = {1, -1, 0, 0};
	private static int[] dj = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[][] maze = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				maze[i][j] = temp[j] == '0' ? true : false;
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		Deque<Point> deque = new ArrayDeque<Point>();
		visited[0][0] = true;
		deque.add(new Point(0, 0, 0));
		
		int min = 0;
		
		while(!deque.isEmpty()) {
			Point poll = deque.poll();
			int i = poll.getI();
			int j = poll.getJ();
			int cnt = poll.getCnt();
			
			if(i == n - 1 && j == m - 1) {
				min = cnt;
				break;
			}
			
			for(int k = 0; k < 4; k++) {
				int nextI = i + di[k];
				int nextJ = j + dj[k];
				
				if(nextI >= 0 && nextI  < n && nextJ >= 0 && nextJ < m && !visited[nextI][nextJ]) {
					visited[nextI][nextJ] = true;
					
					if(maze[nextI][nextJ]) {
						deque.addFirst(new Point(nextI, nextJ, cnt));
					} else {
						deque.addLast(new Point(nextI, nextJ, cnt + 1));
					}
				}
			}			
		}
		
		System.out.println(min);
	}
	
	private static class Point {
		private int i;
		private int j;
		private int cnt;
		
		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		public int getI() {
			return i;
		}
		public int getJ() {
			return j;
		}

		public int getCnt() {
			return cnt;
		}
	}
}