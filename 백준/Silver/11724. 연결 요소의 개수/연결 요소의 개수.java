import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static int n;
    public static int m;
    public static boolean tf[];
    public static int arr[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        tf = new boolean[n+1];
        int count = 0;

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int parsedInt1 = Integer.parseInt(st.nextToken());
            int parsedInt2 = Integer.parseInt(st.nextToken());
            arr[parsedInt1][parsedInt2]=1;
            arr[parsedInt2][parsedInt1]=1;

        }

        for (int i = 1; i <= n; i++) {

            if ( !tf[i] ) {
                Cal(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void Cal(int i) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int num = queue.remove();

            for (int k = 1; k <= n; k++) {
                if(!tf[k] && arr[num][k]==1){
                    queue.add(k);
                    tf[k]=true;
                }
            }
        }
    }
}