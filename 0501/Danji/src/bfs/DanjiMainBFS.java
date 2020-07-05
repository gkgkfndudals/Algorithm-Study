package bfs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DanjiMainBFS {
	static int map[][];
	static int visit[][];
	static int N;
	static int[] dir_x = { 0, -1, 0, 1 };
	static int[] dir_y = { -1, 0, 1, 0 };
	static int cnt;
	static Queue<Point> queue = new LinkedList<Point>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		System.out.print("N 입력: ");
		N = sc.nextInt();

		map = new int[N][N];
		visit = new int[N][N];

		String input;
		
		System.out.println("방 입력");
		for (int i = 0; i < N; i++) {
			input = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		///////////////////////////////////////////////////////////

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					cnt = 1;
					bfs(i, j);
					list.add(cnt);
				}
			}
		}

		System.out.println("총 단지수");
		System.out.println(list.size());

		Collections.sort(list);

		System.out.println("단지내 집의 수를 오름차순");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static void bfs(int x, int y) {
		int new_x;
		int new_y;
		Point point;
		
		visit[x][y]=1;

		queue.offer(new Point(x, y));

		while (queue.isEmpty() != true) {
			point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				new_x = point.x + dir_x[i];
				new_y = point.y + dir_y[i];

				if (new_x >= 0 && new_y >= 0 && new_x < N && new_y < N) {
					if (map[new_x][new_y] == 1 && visit[new_x][new_y] == 0) {
						visit[new_x][new_y] = 1;
						queue.offer(new Point(new_x, new_y));
						cnt++;
					}
				}
			}
		}
	}
	
	
}
