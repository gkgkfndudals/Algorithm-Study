import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class MainTwo {
	static int N, M;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static LinkedHashMap<String, Integer> result_map = new LinkedHashMap<String, Integer>();
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
		
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		
		MyComparator mycomparator = new MyComparator();
		Collections.sort(list, mycomparator);

		LinkedHashMap<String, Integer> sortedmap = new LinkedHashMap<String, Integer>(); //map 정렬 순서를 유지하려면 linked를 사용해야됨
		for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext(); ) {
			Entry<String, Integer> entry = iter.next();
			sortedmap.put(entry.getKey(), entry.getValue());
		}
		
		
		for (String key : sortedmap.keySet()) {
			if (sortedmap.get(key) != 1) {
				cnt++;
				sb.append(key).append("\n");
			}
		}

		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	
	
	static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			// TODO Auto-generated method stub
			int comparision = (o1.getValue() - o2.getValue()) * -1; //-> 내림차순  //양수면 자리바꿈, 음수면 그대로
			return comparision==0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
		}
	}

}
