import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char map[][];
	static boolean visit[][];
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static int ans = 0;
	static ArrayList<Land> list = new ArrayList<Land>();
	static Queue<Land> queue= new LinkedList<Land>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String s= br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='L') {
					Land land = new Land(i, j , 0);
					list.add(land);
				}
			}
		}
		
		bfs();
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		int nx, ny;
		visit= new boolean[N][M];
		queue.offer(list.get(0));
		
		while(!queue.isEmpty()) {
			Land land = queue.poll();
			for(int i=0; i<4; i++) {
				nx= land.x + dir_x[i];
				ny = land.y + dir_y[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(!visit[nx][ny]) {
						
					}
				}
			}
			
		}
		
		
	}

	static class Land{
		int x;
		int y;
		int value;
		
		public Land(int x, int y, int value) {
			this.x= x;
			this.y= y;
			this.value= value;
		}
	}
	
}
