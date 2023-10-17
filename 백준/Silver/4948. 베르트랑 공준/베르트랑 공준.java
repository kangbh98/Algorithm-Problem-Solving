import java.lang.*;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            int n = Integer.parseInt(br.readLine());
            if(n==0){
                return;
            }
            boolean arr[] = new boolean[2*n+1];
            arr[1] = true;
            int count = 0;
            int n_count=0;

            for(int i =1; i<=2*n ; i++){

                if(arr[i]==false){
                    count++;

                    int num = i;
                    int num2 = num;

                    while(num2<=2*n){
                        arr[num2]=true;
                        num2+=num;
                    }
                }
                if(i==n){
                    n_count=count;
                }
            }

            System.out.println(count-n_count);
        }
    }
}