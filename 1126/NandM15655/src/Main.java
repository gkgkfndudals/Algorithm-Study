import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int arr[], ans[];
	static boolean check[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		ans = new int[N];
		check = new boolean[N];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		sol(0 ,0);
		
		System.out.println(sb.toString());

	}
	
	public static void sol(int idx, int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			ans[depth]=arr[i];
			idx++;
			sol(idx, depth+1);
		}
	}
	
}
