import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int dist = num2 - num1;

            if(dist == 1 ){
                System.out.println(1);
                continue;
            }else if(dist == 2){
                System.out.println(2);
                continue;
            }else if(dist == 3){
                System.out.println(3);
                continue;
            }

            
            int max = (int) Math.sqrt(dist);
            int ans = 2*max-1;
            int num3 = dist- max*max;

            while(num3 != 0){
                if(num3-max>=0){
                    num3 -= max;
                    ans++;
                }else{
                    max--;                
                }
            }

            System.out.println(ans); 

        }
    }
}