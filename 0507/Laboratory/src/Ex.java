import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex {
	static int N, M;
	static int map[][];
	static int temp[][];
	static ArrayList<Point> virus_pos = new ArrayList<Point>();
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus_pos.add(new Point(i, j));
			}
		}

		combinationBF(0, 0);

		System.out.println(max);
	}

	static void combinationBF(int idx, int depth) {
		if (depth == 3) {
			copyArr();

			for (Point pos : virus_pos) {
				virusDFS(pos.x, pos.y);
			}

			max = Math.max(max, getSafeArea());

			return;
		}

		for (int i = idx; i < N * M; i++) {
			int x = i / M;
			int y = i % M;

			if (map[x][y] == 0) {
				map[x][y] = 1;
				combinationBF(i + 1, depth + 1);
				map[x][y] = 0;
			}
		}

	}

	static void copyArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	static void virusDFS(int x, int y) {
		int new_x;
		int new_y;

		for (int i = 0; i < 4; i++) {
			new_x = x + dir_x[i];
			new_y = y + dir_y[i];

			if (new_x >= 0 && new_y >= 0 && new_x < N && new_y < M) {
				if (temp[new_x][new_y] == 0) {
					temp[new_x][new_y] = 2;
					virusDFS(new_x, new_y);
				}
			}
		}
	}

	static int getSafeArea() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}

}
