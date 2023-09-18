import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
		int N = Integer.parseInt(br.readLine());
 
		int[][] Cost = new int[N][3];
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
 
			Cost[i][Red] = Integer.parseInt(st.nextToken());
			Cost[i][Green] = Integer.parseInt(st.nextToken());
			Cost[i][Blue] = Integer.parseInt(st.nextToken());
 
		}
 
		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.  
		for (int i = 1; i < N; i++) {
			Cost[i][Red] += Math.min(Cost[i - 1][Green], Cost[i - 1][Blue]);
			Cost[i][Green] += Math.min(Cost[i - 1][Red], Cost[i - 1][Blue]);
			Cost[i][Blue] += Math.min(Cost[i - 1][Red], Cost[i - 1][Green]);
		}
 
		System.out.println(Math.min(Math.min(Cost[N - 1][Red], Cost[N - 1][Green]), Cost[N - 1][Blue]));
	}
 
}