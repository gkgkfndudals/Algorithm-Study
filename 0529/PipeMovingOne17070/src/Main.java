import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int dir_x[] = { 0, 1, 1 }; // 가로, 세로 , 대각선 순서
	static int dir_y[] = { 1, 0, 1 };
	static int ans;

	static Queue<Pipe> queue = new LinkedList<Pipe>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		////////////bfs 시간초과////////// -> 이유를 모름
		//queue.offer(new Pipe(0, 1, 0));
		//bfs();
		////////////////////////////////
		
		dfs(0, 1, 0);
		System.out.println(ans);
	}

	static void dfs(int x, int y, int shape) {
		if (x == N - 1 && y == N - 1) {
			ans++;
			return;
		}

		int next_shape[] = getDir(shape); // 다음에 올 수 있는 사각형 모양

		for (int i = 0; i < next_shape.length; i++) {
			int nx = x + dir_x[next_shape[i]];
			int ny = y + dir_y[next_shape[i]];

			// System.out.println(nx+" , " + ny +" " + next_shape[i]);

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1) //nx, ny 행렬 범위와 벽이 있을때 예외처리
				continue;
			if (next_shape[i] == 2 && (map[nx][ny - 1] != 0 || map[nx - 1][ny] != 0 || map[nx][ny] != 0))
				continue; // 대각선일때 주의칸 확인

			dfs(nx, ny, next_shape[i]);
		}

	}

	static int[] getDir(int shape) {  //shape==0 가로 , ==1 세로, ==2 대각선
		if (shape == 0) {
			int[] ret = { 0, 2 }; // 가로 일때 -> 가로, 대각선
			return ret;
		} else if (shape == 1) {
			int[] ret = { 1, 2 }; // 세로 일때 -> 세로, 대각선
			return ret;
		} else if (shape == 2) {
			int[] ret = { 0, 1, 2 }; // 대각선 일때 -> 가로, 세로 ,대각선
			return ret;
		}

		return null;
	}

	////////////////////////////////////////////////////////////////////////////
	static void bfs() {

		while (!queue.isEmpty()) {
			Pipe pipe = queue.poll();

			if (pipe.x == N - 1 && pipe.y == N - 1) {
				ans++;
				continue;
			}

			for (int i = 0; i < 3; i++) {
				if (pipe.shape == 0 && i == 1) { // 가로일때는 세로가 올수없다
					continue;
				} else if (pipe.shape == 1 && i == 0) { // 세로일때는 가로가 올수없다
					continue;
				}

				if (isPosible(pipe.x, pipe.y, i)) {
					queue.add(new Pipe(pipe.x + dir_x[i], pipe.y + dir_y[i], i));
				}
			}

		}

	}

	public static boolean isPosible(int x, int y, int i) {
		int dx = x + dir_x[i];
		int dy = y + dir_y[i];

		if (dx > N - 1 | dy > N - 1) { // 사각형 범위를 벗어 날 경우
			return false;
		}

		if (i == 2) { // 대각 일 경우
			if (map[dx - 1][dy] != 0 || map[dx][dy - 1] != 0 || map[dx][dy] != 0) {
				return false;
			}
		} else {
			if (map[dx][dy] == 1) {
				return false;
			}
		}

		return true;
	}

	///////////////////////////////////////////////////////////////

	static class Pipe {
		int x;
		int y;
		int shape;

		public Pipe(int x, int y, int shape) {
			this.x = x;
			this.y = y;
			this.shape = shape; // 0 가로, 1 세로, 2대각선
		}
	}

}
