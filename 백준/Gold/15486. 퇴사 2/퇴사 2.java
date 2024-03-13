import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][2];
        int ans[] = new int[n+2];
        for(int i = 1 ; i < n+1 ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = n ; i > -1 ; i--){
            
            if(i+arr[i][0] > n+1){
                ans[i] = ans[i+1];
                continue;
            }
            
            ans[i] = Math.max(ans[i+arr[i][0]]+arr[i][1],ans[i+1]);
        }
          
        
        System.out.println(ans[0]);  
        
    }
}