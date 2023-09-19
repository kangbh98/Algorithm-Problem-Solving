import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m =Integer.parseInt(st.nextToken());
        int n =Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for( int i = m ; i <= n ; i++){
            if(i==1) continue;
            if(i==2) {
                sb.append(i+"\n");
                continue;
            }

            double sqrt = Math.sqrt((double) i);
            int ceil = (int) Math.ceil(sqrt);
            boolean t = true;

            for( int k = 2 ; k <= ceil; k++){
                if(i%k==0){
                    t = false;
                    break;
                }
            }
            if(t==true){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);

    }
}