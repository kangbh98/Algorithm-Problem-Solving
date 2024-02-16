import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static ArrayList<Integer> arr[];
    static boolean visited[];
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1].add(num2);
            arr[num2].add(num1);
        }

        visited = new boolean[n + 1];
        dfs(start);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(start);
    }
    public static void dfs(int start){
        if(!visited[start]) {
            System.out.print(start+" ");
            visited[start] = true;
            Collections.sort(arr[start]);
            for(Integer i :arr[start]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);


        while (!q.isEmpty()) {

            int num = q.remove();
            if (!visited[num]) {
                System.out.print(num+" ");
                visited[num] = true;
                Collections.sort(arr[num]);
                for(Integer i :arr[num]){
                    q.add(i);
                }
            }
        }

    }


}