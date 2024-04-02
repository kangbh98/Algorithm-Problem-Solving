import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static long A, B;
	static Map<Long,Long> dp = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		int v = 0;
		for(int i=0;i<10;i++) {
			v += i;
			dp.put((long)i, (long)v);
		}
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			

			sb.append("#" + test_case + " " + (RR(B) - RR(A-1))).append('\n');
		}
		System.out.println(sb);
	}
	
	static int sum(long n) {
		int ret = 0;
		for(int i=1;i<=n;i++) {
			ret += i;
		}
		return ret;
	}
	
	static long RR(long n) {
		long v = (long)Math.pow(10, count(n)-1);

		if(n<=0) return 0;
		if(dp.containsKey(n)) return dp.get(n);

		long ret = RR(n-1-n%v) + (n/v) * (n%v+1) + RR(n%v);
		dp.put(n,ret);
		return ret;
	}
	
	static int count(long n) {
		return String.valueOf(n).length();
	}
}
