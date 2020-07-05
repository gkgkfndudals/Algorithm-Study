import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex {
	static int V, E, K;
	static ArrayList<Edge> list[] = new ArrayList[V];
	static int ans[];
	static boolean visit[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[V + 1];
		ans = new int[V + 1];
		visit = new boolean[V + 1];
		Arrays.fill(ans, Integer.MAX_VALUE);

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list[start].add(edge);
		}

		dijkstra();

		for(int i=1; i<=V;i++)
	    	bw.write((ans[i]==Integer.MAX_VALUE)?"INF\n":ans[i]+"\n");
	    
	    bw.flush();
	    bw.close();
	}

	static void dijkstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.offer(new Edge(K, 0));
		ans[K] = 0;

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			int current = edge.end;
			
			visit[current] = true;

			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i).end;
				int value = list[current].get(i).distance;

				if (ans[next] > ans[current] + value) {
					ans[next] = Math.min(ans[next], ans[current] + value);
					queue.offer(new Edge(next, value));
				}
			}

		}

	}
	
	static class Edge implements Comparable<Edge>{
        int end;
        int distance;

        Edge(int end, int distance){
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.distance < o.distance) return -1;
            else if(this.distance == o.distance) return 0;
            else return 1;
        }
    }
	
}

