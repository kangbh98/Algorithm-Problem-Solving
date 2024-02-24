import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{


    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            boolean flag = true;
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n+1];
            int ans[] = new int[n+1];
            boolean visited[] = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = n; i > 0; i--) {

                int count = arr[i];
                int index = -1;

                for (int j = 1; j <= n; j++) {
                    if(!visited[j]){
                        count--;
                    }
                    if(count<0){
                        index = j;
                        break;
                    }
                }

                if(index ==-1){
                    flag = false;
                    break;
                }else {
                    visited[index] = true;
                    ans[i] = index;
                }
            }

            if (flag){
                for (int i = 1; i < n+1; i++) {
                    System.out.print(ans[i]+" ");
                }
                System.out.println();
            }else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}