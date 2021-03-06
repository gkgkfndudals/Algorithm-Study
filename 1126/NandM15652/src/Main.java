import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  �ߺ�O ����
 */

public class Main {
	static int N, M;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	static int idx=1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		
		sol(1, 0);
		
		System.out.println(sb.toString());
		br.close();
		
	}
	
	public static void sol(int idx, int depth) {
		if(depth==M) {
			for(int i=0; i<M ; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i=idx; i<=N; i++) {
			arr[depth]=i;
			sol(i, depth+1);
		}
		
	}

}
