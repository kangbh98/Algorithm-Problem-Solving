import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first_s = br.readLine();
        String ans_s = br.readLine();
        int first[] = new int[n];
        int first2[] = new int[n];
        int ans[] = new int[n];
        int count = 0;
        int count2 = 0;


        for (int i = 0; i < n ; i++) {
            first[i] = first_s.charAt(i)-'0';
            first2[i] = first_s.charAt(i)-'0';
            ans[i] = ans_s.charAt(i)-'0';
        }


        first[0] = first[0]^1;
        first[1] = first[1]^1;
        count++;

        for (int i = 1; i < n - 1; i++) {
            if(ans[i-1]!=first[i-1]){
                first[i-1] = first[i-1]^1;
                first[i] = first[i]^1;
                first[i+1] = first[i+1]^1;
                count++;
            }
            if(ans[i-1]!=first2[i-1]){
                first2[i-1] = first2[i-1]^1;
                first2[i] = first2[i]^1;
                first2[i+1] = first2[i+1]^1;
                count2++;
            }
        }

        if(ans[n-2]!=first[n-2]){
            first[n-2] = first[n-2]^1;
            first[n-1] = first[n-1]^1;
            count++;
        }
        if(ans[n-2]!=first2[n-2]){
            first2[n-2] = first2[n-2]^1;
            first2[n-1] = first2[n-1]^1;
            count2++;
        }

        for (int i = 0; i < n ; i++) {
            if(first[i]!= ans[i]){
                count =Integer.MAX_VALUE;
            }
            if(first2[i]!= ans[i]){
                count2 =Integer.MAX_VALUE;
            }
        }

        if(count==Integer.MAX_VALUE && count2 == Integer.MAX_VALUE){
            System.out.println(-1);
        }else if( count <= count2){
            System.out.println(count);
        }else if( count2 < count){
            System.out.println(count2);

        }

    }
}
