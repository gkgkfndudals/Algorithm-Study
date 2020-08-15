import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static int karr[];
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		karr = new int[K];

		for (int i = 0; i < K; i++) {
			karr[i] = Integer.parseInt(br.readLine());
		}

		// ans = (int) binary_search();

		Arrays.sort(karr);
		
		ans = (int) binary_search();
		System.out.println(ans);

	}

	static long binary_search() {
		long max = karr[K - 1], min = 1, mid = 0;

		while (max >= min) {
			int cnt = 0;
			mid = (max + min) / 2;

			for (int i = 0; i < K; i++) {
				cnt = (int) (cnt + karr[i] / mid);
			}

			if (cnt >= N) {
				min = mid + 1;
			} else if (cnt < N) {
				max = mid - 1;
			}

		}

		return max;
	}

}
