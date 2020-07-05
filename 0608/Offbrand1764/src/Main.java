import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N, M;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			String s = br.readLine();
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}

		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(map);

		for (String key : tm.keySet()) {
			if (tm.get(key) != 1) {
				cnt++;
				sb.append(key).append("\n");
			}
		}

		System.out.println(cnt);
		System.out.println(sb.toString());

	}

}
