import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int arr[][];
    static boolean visited[];
    static int Max_value = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int depth = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            recursion(depth,0,i,i);
        }
        System.out.println(Max_value);
    }
    public static void recursion(int depth, int total,int start,int start_end){

        if(depth == n-1){
            if (arr[start][start_end] != 0) {
                total += arr[start][start_end];
                Max_value=Math.min(total,Max_value);
            }
            return;
        }

        for (int i = 0; i < n; i++) {

            if(!visited[i]&&arr[start][i]!=0){
                visited[i]=true;
                total += arr[start][i];
                recursion(depth + 1, total,i,start_end);
                total -= arr[start][i];
                visited[i]=false;
            }
        }
    }

}