package NM3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NMmainThree {
	static int N, M;
	static int list[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String str= "";
		str=br.readLine();
		String[] input = str.split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		list = new int[N];
		dfs(0);
		
		System.out.println(sb.toString());
		br.close();
	}

	static void dfs(int cnt) {
		if (M == cnt) {
			for (int j = 0; j < M; j++)
				sb.append(list[j]).append(" ");
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			list[cnt] = i;
			dfs(cnt + 1);

		}
	}

}
