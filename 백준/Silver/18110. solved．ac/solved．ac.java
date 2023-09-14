import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double execept_d = (double) n * 0.15;
        int except = (int)Math.round(execept_d);
        int first = except -1 ;
        int last =  n - except;


        int arr[] = new int[n];
        int total = 0;

        for( int i = 0 ; i < n ; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for( int i = 0 ; i < n ; i++){
            if(i>first&&i<last){
                total+=arr[i];
            }
        }
        double d_average = (double) total/(last-first-1);
        int average = (int) Math.round(d_average);
        System.out.println(average);
    }
}
