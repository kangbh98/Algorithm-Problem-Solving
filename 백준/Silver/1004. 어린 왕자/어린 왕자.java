import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < n ;i++){

                st = new StringTokenizer(br.readLine());
                int x3 = Integer.parseInt(st.nextToken());
                int y3 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                double left_dist = Math.sqrt(Math.abs(x1-x3)*Math.abs(x1-x3)+Math.abs(y1-y3)*Math.abs(y1-y3));
                double right_dist = Math.sqrt(Math.abs(x2-x3)*Math.abs(x2-x3)+Math.abs(y2-y3)*Math.abs(y2-y3));
                
                if(left_dist<dist && right_dist>dist){
                    count++;
                }else if(left_dist>dist && right_dist<dist){
                    count++;
                }
                
            }
            
            System.out.println(count);
        }           
    }
}