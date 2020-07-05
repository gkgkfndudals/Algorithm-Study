import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char map[][];
	static Queue<Point> w_queue = new LinkedList<Point>();
	static Queue<Point> h_queue = new LinkedList<Point>();
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static boolean visit[][];
	static Point goal;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열

		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '*')
					w_queue.offer(new Point(i, j)); //water queue
				else if (map[i][j] == 'S')
					h_queue.offer(new Point(i, j)); //고슴도치 queue
			}
		}

		while (true) {
			if(h_queue.size()==0) { //마지막 도착지점에서 offer를 하기 때문에 size가 0이면 도착 못한 것
				System.out.println("KAKTUS"); 
				return;
			}
			waterBFS();
			cnt++;
			if(hedgehogBFS()) { //도착하면 true
				System.out.println(cnt);
				return;
			}
		}

	}

	static void waterBFS() {
		int nx, ny;
		Point p;
		int current_size = w_queue.size();

		for (int k = 0; k < current_size; k++) {
			p = w_queue.poll();
			visit[p.x][p.y] = true;
			
			for (int i = 0; i < 4; i++) {
				nx = p.x + dir_x[i];
				ny = p.y + dir_y[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if (!visit[nx][ny] && map[nx][ny]!='D' && map[nx][ny]!='X') {
						visit[nx][ny] = true;
						map[nx][ny] = '*';
						w_queue.offer(new Point(nx, ny));
					}
				}
			}

		}

	}

	static boolean hedgehogBFS() {
		int nx, ny;
		Point p;
		int current_size = h_queue.size();
		for (int k = 0; k < current_size; k++) {
			p = h_queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dir_x[i];
				ny = p.y + dir_y[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if (map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						h_queue.add(new Point(nx, ny));
					}
					if (map[nx][ny] == 'D') {
						h_queue.add(new Point(nx, ny));
						return true;
					}
				}
			}

		}

		return false;

	}

}
