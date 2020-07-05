import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2 {
	static int T, W, H;
	static char map[][];
	static boolean visit[][];
	static Queue<Point> fire_q;
	static Queue<Point> person_q;
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static int ans;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());

		for (int k = 0; k < T; k++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // �ʺ�
			H = Integer.parseInt(st.nextToken()); // ����
			map = new char[H][W];
			visit = new boolean[H][W];
			ans = 1;
			
			fire_q = new LinkedList<Point>();
			person_q = new LinkedList<Point>();

			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '*') {
						fire_q.offer(new Point(i, j));
						visit[i][j] = true;
					} else if (map[i][j] == '@') {
						person_q.offer(new Point(i, j));
					}
				}
			}

			while (true) {
				if (person_q.isEmpty()) {
					sb.append("IMPOSSIBLE").append("\n");
					break;
				}
				fireBFS();

				ans++;

				if (personBFS()) {
					sb.append(ans).append("\n");
					break;
				}
			}

		}
		
		System.out.println(sb.toString());

	}

	static void fireBFS() {
		int nx, ny;
		int len = fire_q.size();

		for (int k = 0; k < len; k++) {
			Point p = fire_q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dir_x[i];
				ny = p.y + dir_y[i];

				if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
					if (!visit[nx][ny] && map[nx][ny] != '#') {
						map[nx][ny] = '*';
						fire_q.offer(new Point(nx, ny));
					}
				}
			}
		}

	}

	static boolean personBFS() {
		int nx, ny;
		int len = person_q.size();

		for (int k = 0; k < len; k++) {
			Point p = person_q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dir_x[i];
				ny = p.y + dir_y[i];
				if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
					if (!visit[nx][ny] && map[nx][ny] == '.' && (nx == 0 || ny == 0 || nx == H - 1 || ny == W - 1)) {
						person_q.offer(new Point(nx, ny));
						return true;
					} else if (map[nx][ny] == '.' && !visit[nx][ny]) {
						map[nx][ny] = '@';
						person_q.offer(new Point(nx, ny));
					}
				}
			}

		}
		return false;
	}
}
