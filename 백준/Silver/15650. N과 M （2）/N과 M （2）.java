import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int arr[];
    static int arr2[];
    static boolean visit[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        arr2 = new int[m];
        visit = new boolean[n];
        int count = 0;
        int start_point =0;

        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }

        recursion(count,start_point);
    }

    public static void recursion(int count,int start_point) {

        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr2[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start_point; i < n; i++) {

            if (!visit[i] ){
                visit[i] = true;
                arr2[count] = i+1;
                recursion(count + 1,i+1);
                visit[i] =false;
            }
        }
    }
}