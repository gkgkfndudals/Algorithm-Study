import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int dp[];
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		func();
		
		System.out.println(max);
	}

	static void func() {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				dp[0] = arr[0];
				max = Math.max(max, dp[i]);
				continue;
			}

			dp[i] = dp[i - 1] + arr[i] > arr[i] ? dp[i-1]+arr[i]: arr[i] ;
			
			max = Math.max(max, dp[i]);
		}
	}

}
