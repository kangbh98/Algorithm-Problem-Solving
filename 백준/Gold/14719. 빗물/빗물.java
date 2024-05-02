import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int H, W;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
//		4 4
//		3 0 1 4
		st = new StringTokenizer(br.readLine());
		

		for (int i = 0; i < W; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = H-1; j >= H - n; j--) {
				map[j][i] = 1;
			}
		}
//		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
//		
		int result = 0;
		for (int i = 0; i < H; i++) {
			int flag = 0;
			int count = 0;
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1 && flag == 1) {
					result += count;
					count = 0;
					continue;
				}
				if (map[i][j] == 1) {
					flag = 1;
					count = 0;
				}
				else if (map[i][j] == 0) {
					count ++;
				}
			}
		}
		System.out.println(result);
	}
}