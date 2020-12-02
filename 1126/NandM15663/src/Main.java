import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int arr[], ans[];
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set = new LinkedHashSet<>();

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

		sol(0);
		
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	public static void sol(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]).append(" ");
			}
			set.add(sb.toString());
			sb.delete(0,sb.length());
			return;
		}

		
		for (int i=0; i<arr.length; i++) {
			
			if(!check[i]) {
				ans[depth] = arr[i];
				check[i] = true;
				sol(depth + 1);
				check[i] = false;
			}
			
		}
	}

}
