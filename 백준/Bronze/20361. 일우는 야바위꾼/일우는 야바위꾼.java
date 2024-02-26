import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		//for(int tc = 1; tc <= T; tc++) {
			//sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //종이컵의 수
			int X = Integer.parseInt(st.nextToken()); //현재 간식이 들어 있는 종이컵
			int K = Integer.parseInt(st.nextToken()); //종이 컵을 바꾼 횟수
			int answer = X;
			for(int i = 0; i < K; i++) { //종이컵 k번 자리 바꾸기
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if(A == answer) answer = B;
				else if(B == answer) answer = A;
			}
			sb.append(answer).append("\n");
		//}
		System.out.println(sb);
	}

}
