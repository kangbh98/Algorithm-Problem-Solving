import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int arr[][];
    static boolean visited[];
    static int total =Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr= new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int depth=0;
        recursion(depth,1);
        System.out.println(total);
    }

    public static void recursion(int depth,int c) {

        if (depth == n / 2) {
            int calculate = Calculate();
            if(calculate<total)
            total = calculate;
            return;
        }

        for (int i = c; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                recursion(depth+1,i);
                visited[i] = false;
            }
        }
    }

    public static int Calculate(){
        int total1=0;
        int total2=0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == true) {
                for(int j = 1; j <= n; j++) {
                    if (visited[j] == true) {
                        total1+=arr[i][j];
                    }
                }
            }else if (visited[i] == false) {
                for(int j = 1; j <= n; j++) {
                    if (visited[j] == false) {
                        total2+=arr[i][j];
                    }
                }
            }
        }
        return Math.abs(total1-total2);
    }
}