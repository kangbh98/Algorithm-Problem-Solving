import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        long dp[] = new long[num.length()];

        if(num.length() == 1 && num.charAt(0)-'0' == 0 ){
            System.out.println(0);
            return;
        }else if(num.length() == 1 && num.charAt(0)-'0' != 0){
            System.out.println(1);
            return;
        }
        dp[0] = 1;


        int num1 = (num.charAt(0)-'0')*10+num.charAt(1)-'0';
        if(num.charAt(0)-'0'== 0 || num.charAt(1)-'0'== 0 && num.charAt(0)-'0' > 2 ){
            System.out.println(0);
            return;
        } else if(num1 <= 26 && num.charAt(1)-'0' == 0 ){
            dp[1] = 1;
        } else if(num1 <= 26 ){
            dp[1] = 2;
        } else{
            dp[1] = 1;
        }

        for(int i = 2 ; i < num.length() ; i++){
            
            int num2 = num.charAt(i-1)-'0';
            int num3 = num.charAt(i)-'0';
            
            if( num3 == 0){

                if(num2==1 || num2 == 2){
                    dp[i]+= dp[i-2];
                    dp[i-1] = 0; 
                }else{
                    System.out.println(0);
                    return;
                }
                
            }else if( num3 != 0 ){

                dp[i] += dp[i-1];

                if(num2!= 0 && num2*10+num3 <= 26){
                    dp[i] += dp[i-2];
                }
            }
            dp[i] %= 1000000;
        }

        // for(long a : dp){
        //     System.out.println(a);
        // }

        System.out.println(dp[num.length()-1]%1000000);
    }
}