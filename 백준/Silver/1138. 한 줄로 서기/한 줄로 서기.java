import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int tallPeople[] = new int[n+1];
        int ans[] = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < n ; i++){
            tallPeople[i] = Integer.parseInt(st.nextToken());
            ans[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1 ; i < n+1 ; i++){
            
            int 키큰사람최대 = tallPeople[i];
            int 키큰사람수 = 0;
            int index = 1;
            while(키큰사람수 <= 키큰사람최대 && index<n+1){

                if(ans[index] == Integer.MAX_VALUE){
                    키큰사람수++;
                    index++;
                }else{
                    index++;
                }
            }
            ans[index-1] = i;
                
        }
        
        for(int i = 1 ; i < n+1 ; i++){
            System.out.print(ans[i]+" ");}
        
    }
}