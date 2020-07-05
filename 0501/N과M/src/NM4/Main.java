package NM4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int list[];
	static boolean check[];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new int[N];
		check = new boolean[N];

		dfs(0, 0);

		System.out.println(sb.toString());
	}

	static void dfs(int idx, int depth) {
		if (depth == M) {
			for (int j = 0; j < M; j++)
				sb.append(list[j]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			list[depth] = i + 1;
			//check[i] = true;
			dfs(i, depth + 1);
			//check[i] = false;
		}
	}

}
