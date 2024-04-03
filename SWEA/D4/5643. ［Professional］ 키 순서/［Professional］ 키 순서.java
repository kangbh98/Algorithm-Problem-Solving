import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] in;
	static int[] out;
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			in = new int[N+1];
			out = new int[N+1];
			visited = new boolean[N+1];
			adjList = new List[N+1];
			for(int i=1;i<=N;i++) {
				adjList[i] = new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
			}
			
			for(int i=1;i<=N;i++) {
				visited = new boolean[N+1];
				cnt = 0;
				doDFS(i);
				out[i] = cnt;
			}
			int answer = 0;
			for(int i=1;i<=N;i++) {
				if(in[i]+out[i] -2 == N-1) answer++;
//				System.out.println(in[i] + " " + out[i]);
			}
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
	
	static void doDFS(int cur) {
		in[cur]++;
		cnt++;
		visited[cur] = true;
		for(int next : adjList[cur]) {
			if(visited[next]) continue;
			doDFS(next);
		}
	}
}
