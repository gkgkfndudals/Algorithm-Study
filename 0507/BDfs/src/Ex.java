import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M,V;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		boolean []visited = new boolean[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < list.length; i++) {
			list[i].sort(null);
		}
		dfs(list,visited,V);
		bw.newLine();
		visited = new boolean[N+1];
		bfs(list,visited,V);
		bw.close();
		  
	}
	static void dfs(ArrayList<Integer>[] list, boolean[] visited, int st) throws IOException{
		visited[st]=true;
		bw.write(st+" ");
		
		for (int idx : list[st]) {
			if(!visited[idx]) {
				dfs(list,visited,idx);
			}
		}
	}
	
	static void bfs(ArrayList<Integer>[] list, boolean[] visited, int st) throws IOException{
		Queue<Integer> qq = new LinkedList<Integer>();
		qq.add(st);
		visited[st] = true;
		
		int cur;
		while (!qq.isEmpty()) {
			cur=qq.poll();
			bw.write(cur+" ");
			visited[cur]=true;
			for (int i = 0; i < list[cur].size(); i++) {
				if(!visited[list[cur].get(i)]) {
					qq.add(list[cur].get(i));
					visited[list[cur].get(i)]=true;
				}
			}
		}
	}
}
