import java.util.*;
import java.io.*;

class Solution
{
    static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static HashSet<String> hs; // HashSet을 통해 중복된 값은 자동으로 거른다.
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            hs = new HashSet<>();
            StringTokenizer st;
            
            map = new int[4][4];
            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    move(i, j, 0, ""+map[i][j]);
                }
            }
            System.out.println("#" + test_case + " " + hs.size());
		}
	}
    
    static void move(int x, int y, int depth, String str) { // depth와 HashSet에 넣을 str값을 넘겨준다.
		
		if(depth == 6) { // 첫 격자의 수 제외하고 6개의 격자까지 추가하면 HashSet에 추가하고 종료한다.
			hs.add(str);
			return;
		}
		for(int t=0; t<4; t++) {
			int nx = x + dx[t]; //새로운 격자 좌표
			int ny = y + dy[t]; //새로운 격자 좌표
			
			if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4) { // 격자판 범위 안이면?
            	// 깊이 끝까지 들어가야 하므로 재귀(스택 구조)를 사용한다.
				move(nx, ny, depth + 1, str+map[nx][ny]); // depth값을 +1 해주고 새로운 격자값을 문자열에 붙여준다.
			}
		}
		
	}
}