import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visit[][];
	static PriorityQueue<Person> queue = new PriorityQueue<Person>();
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		int nx, ny, weight;
		visit = new boolean[N][M];
		queue.offer(new Person(0, 0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Person person = queue.poll();
			if (person.x == N - 1 && person.y == M - 1) {
				ans = person.w;
				return;
			}

			for (int i = 0; i < 4; i++) {
				nx = person.x + dir_x[i];
				ny = person.y + dir_y[i];
				weight = person.w;

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (!visit[nx][ny]) {
						visit[nx][ny] = true;
						if (map[nx][ny] == 0) {        
							queue.offer(new Person(nx, ny, weight));
						} else if (map[nx][ny] == 1) {    //벽이니 현재 w에서 + 1
							queue.offer(new Person(nx, ny, weight + 1));
						}

					}
				}
			}

		}
	}

	static class Person implements Comparable<Person> {
		int x;
		int y;
		int w;

		public Person(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			if (this.w < o.w)
				return -1;
			else if (this.w == o.w)
				return 0;
			else
				return 1;
		}
	}

}
