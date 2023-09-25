import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    
    public static int w = 0;
    public static int b = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(w);
        System.out.println(b);

    }

    public static void partition(int row, int col, int size) {

        //
        if(colorCheck(row, col, size)) {
            if(board[row][col] == 0) {
                w++;
            }
            else {
                b++;
            }
            return;
        }

        int newSize = size / 2;	
        partition(row, col, newSize);						
        partition(row, col + newSize, newSize);				
        partition(row + newSize, col, newSize);				
        partition(row + newSize, col + newSize, newSize);	
    }
    
    public static boolean colorCheck(int row, int col, int size) {

        int color = board[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}