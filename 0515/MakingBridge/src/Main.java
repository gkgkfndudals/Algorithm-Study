import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class MapPoint {
	int x;
	int y;

	public MapPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int map[][];
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static int N;
	static int visit[][];

	static Queue<Point> queue = new LinkedList<Point>();

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int islandNum = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					map[i][j] = islandNum;
					visit[i][j] = 1;
					islandDFS(i, j, islandNum);
					islandNum++;
				}

			}
		}

		System.out.println(min);

	}

	static void islandDFS(int x, int y, int islandNum) {
		int new_x, new_y;

		for (int i = 0; i < 4; i++) {
			new_x = x + dir_x[i];
			new_y = y + dir_y[i];

			if (new_x >= 0 && new_y >= 0 && new_x < N && new_y < N) {
				if (map[new_x][new_y] == 1 && visit[new_x][new_y] == 0) {
					visit[new_x][new_y] = 1;
					map[new_x][new_y] = islandNum;
					islandDFS(new_x, new_y, islandNum);
				}
			}
		}

	}

	static void bfs(int x, int y) {

	}

}
