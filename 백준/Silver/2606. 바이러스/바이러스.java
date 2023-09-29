import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static int arr[][];
    public static boolean tf[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int total = 0;
        arr = new int[n+1][n+1];
        tf = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parsedInt = Integer.parseInt(st.nextToken());
            int parsedInt1 = Integer.parseInt(st.nextToken());

            arr[parsedInt1][parsedInt]=1;
            arr[parsedInt][parsedInt1]=1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        tf[1]=true;

        while (!queue.isEmpty()) {

            int num = queue.remove();

            for (int i = 1; i <= n; i++) {
                if (!tf[i] && arr[num][i] == 1) {
                    queue.add(i);
                    tf[i]=true;
                    total++;
                }
            }
        }

        System.out.println(total);

    }

}