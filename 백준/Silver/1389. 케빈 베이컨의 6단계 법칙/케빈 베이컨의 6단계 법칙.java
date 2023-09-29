import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static int arr[][];
    public static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int total = m*m;
        int pick = 0;
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parsedInt = Integer.parseInt(st.nextToken());
            int parsedInt2 = Integer.parseInt(st.nextToken());
            arr[parsedInt][parsedInt2] = 1;
            arr[parsedInt2][parsedInt] = 1;
        }

        for (int i = 1; i <= n; i++) {

            int num = Cal(i);

            if(num<total){
                total=num;
                pick = i;
            }
        }
        System.out.println(pick);
    }

    public static int Cal(int node) {

        Queue<Integer> queue = new LinkedList<>();
        boolean tf[]= new boolean[n+1];

        tf[node]=true;
        queue.add(node);
        int cnt = 0;
        int dist[] = new int[n + 1];

        while (!queue.isEmpty()) {

            int num = queue.remove();

            for(int i = 1 ; i <=n ; i++){
                if ( !tf[i] && arr[num][i]==1){
                    queue.add(i);
                    tf[i]=true;
                    dist[i] = dist[num]+1;
                    cnt += dist[i];
                }
            }
        }
        return cnt;
    }
}