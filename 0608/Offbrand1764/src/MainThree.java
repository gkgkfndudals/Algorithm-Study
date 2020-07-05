import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainThree {
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] s = new String[N + M];

		for (int i = 0; i < N + M; i++) {
			s[i] = br.readLine();
		}

		Arrays.sort(s);
		
		for(int i=1; i<N+M; i++) {
			if(s[i].equals(s[i-1])) {
				sb.append(s[i]).append("\n");
				cnt++;
			}
		}

		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}
