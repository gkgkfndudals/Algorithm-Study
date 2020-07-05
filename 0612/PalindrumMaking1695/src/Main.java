import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[], dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new int[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(func(0, N-1));
	}
	
	//top down ���
	static int func(int x, int y) {
		if(x>y)
			return 0;
		if(dp[x][y] != 0)
			return dp[x][y];
		if(arr[x] == arr[y]) 
			return func(x+1, y-1);
		
		return dp[x][y]= 1+Math.min(func(x+1,y), func(x, y-1));
	}
}
