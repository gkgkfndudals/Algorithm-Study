import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[];
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		ans = binary_search();

		System.out.println(ans);

	}

	static int binary_search() {
		int max, min = 1, mid = 0;

		max = arr[N - 1];

		while (max >= min) {
			long height = 0;
			mid = (max + min) / 2;

			for (int i = 0; i < N; i++) {
				int sub = arr[i]-mid;
				
				if(sub>0) {
					height = height + (arr[i]-mid);
				}else if (sub<0 && sub == 0){
					continue;
				}

			}

			if (height >= M) {
				min = mid + 1;
			} else if (height < M) {
				max = mid - 1;
			}
		}

		return max;
	}

}
