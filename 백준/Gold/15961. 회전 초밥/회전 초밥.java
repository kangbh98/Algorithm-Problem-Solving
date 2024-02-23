import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int belt[] = new int[n+k];
        int sushiMenu[] = new int[d + 1];
        sushiMenu[c] = 1;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            belt[n + i] = belt[i];
        }


        for (int i = 0; i < k; i++) {
            int num =belt[i];

            sushiMenu[num]++;
            if(sushiMenu[num]==1){
                ans++;
            }
        }
        int Max_Ans = ans;



        for (int i = 1; i < n; i++) {

            int 뺄값 = belt[i - 1];
            int 더할값 = belt[i + k-1];

            sushiMenu[뺄값]--;
            if(sushiMenu[뺄값]==0){
                ans--;
            }

            sushiMenu[더할값]++;
            if(sushiMenu[더할값]==1){
                ans++;
            }
            Max_Ans = Math.max(Max_Ans, ans);
        }


        System.out.println(Max_Ans);

    }
}