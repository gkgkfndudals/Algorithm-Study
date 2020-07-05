import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanjiMain {
	static int[] dir_x = { 0, -1, 0, 1 };
	static int[] dir_y = { -1, 0, 1, 0 };
	static int N;
	static int map[][];
	static int visit[][];
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list= new ArrayList<>();
		
		String input;

		System.out.print("N 입력: ");
		N = sc.nextInt();

		map = new int[N][N];
		visit = new int[N][N];

		System.out.println("방 입력");
		for (int i = 0; i < N; i++) {
			input = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		///////////////////////////////////////////////////////

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}

		
		Collections.sort(list);
		
		System.out.println("총 단지수: "+ list.size());
		
		System.out.println("단지내 집의 수 오름차순");
		for(int i : list) {
			System.out.println(i);
		}
	}

	static void dfs(int x, int y) {
		int new_x, new_y;
		visit[x][y] = 1;

		for (int j = 0; j < 4; j++) {
			new_x = x + dir_x[j];
			new_y = y + dir_y[j];

			if (new_x >= 0 && new_y >= 0 && new_x < N && new_y < N) {
				if (map[new_x][new_y] == 1 && visit[new_x][new_y] == 0) {
					//visit[new_x][new_y] = 1;
					cnt++;
					System.out.println("cnt: " + cnt);
					dfs(new_x, new_y);
					
				}
			}
		}

		return ;
	}
	
}