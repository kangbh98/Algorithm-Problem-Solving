import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int arr[];
    static int 모든수열[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        모든수열 = new int[n];
        for (int i = 0; i < n; i++) {
            모든수열[i]=i+1;
        }
        int depth = 0;

        recursion(0,depth);
    }

    static void recursion(int start,int depth) {

        if (depth == m) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth]=모든수열[i];
            recursion(i,depth+1);
        }
    }
}