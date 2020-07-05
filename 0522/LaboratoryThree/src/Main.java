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
	static int map[][];
	static int copy[][];
	static boolean visit[][];
	static ArrayList<Virus> virus_pos = new ArrayList<Virus>();
	static Virus pos[];
	static Queue<Virus> queue = new LinkedList<Virus>();
	static int dir_x[] = { 0, -1, 0, 1 };
	static int dir_y[] = { -1, 0, 1, 0 };
	static int blank_cnt = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		pos = new Virus[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus_pos.add(new Virus(i, j, 0));
				else if (map[i][j] == 0)
					blank_cnt++;
			}
		}

		blank_cnt = blank_cnt + (virus_pos.size() - M);  

		combination(0, 0);

		min = (min == Integer.MAX_VALUE ? -1 : min);

		System.out.println(min);

	}

	static void combination(int idx, int depth) {
		if (depth == M) {
			virusBFS(blank_cnt);
			return;
		}

		for (int i = idx; i < virus_pos.size(); i++) {
			pos[depth]  = virus_pos.get(i);
			combination(i + 1, depth + 1);
		}
	}

	static void virusBFS(int blank_cnt) {
		int nx, ny;
		visit = new boolean[N][N]; //조합마다 초기화 false
		int sec =0 ;
		
		for (int i = 0; i < pos.length; i++) {
			visit[pos[i].x][pos[i].y] = true;  //이거 삭제하고 밑에꺼 하면 에러??
			queue.offer(pos[i]);
		}
		
		while (!queue.isEmpty()) {
			Virus virus = queue.poll();
			
			//visit[virus.x][virus.y] = true;  

			for (int i = 0; i < 4; i++) {
				nx = virus.x + dir_x[i];
				ny = virus.y + dir_y[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visit[nx][ny] && map[nx][ny] != 1) {		
						if(map[nx][ny]==0) {
							sec = virus.val +1;  //비활성 바이러스 주위에 빈칸이면 ++ 해준다
						}
						visit[nx][ny] = true;
						blank_cnt--;
						queue.add(new Virus(nx, ny, virus.val + 1)); // 비활성 바이러스여도 시간 값은 갖고있어야된다.
					}
				}
			}

			if (blank_cnt == 0) {
				min = Math.min(min, sec);
				
			}
		}

	}

}

class Virus {
	int x;
	int y;
	int val;

	public Virus(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
