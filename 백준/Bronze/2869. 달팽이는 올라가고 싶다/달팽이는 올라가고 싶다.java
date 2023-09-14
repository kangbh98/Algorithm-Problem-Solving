import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken())-a;
        int k;

        if(v%(a-b)!=0){
             k = v/(a-b)+1;
        } else{
             k= v/(a-b);
        }

        System.out.println(k+1);

    }
}