import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static boolean visited[];
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int total=0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        recursion(1,0);

        if(total%2==0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }

    static void recursion(int node ,int depth){

        visited[node] = true;
        boolean flag = true;
        for(int i : list.get(node)){
            if(!visited[i]){
                flag = false;
                recursion(i,depth+1);
            }
        }
        if(flag){
            total += depth;
        }
    }
}