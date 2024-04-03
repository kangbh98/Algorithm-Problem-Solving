import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int arr[];
    static int ansUp[];
    static int ansDown[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ansUp = new int[n];
        ansDown = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, LIS(i)+LDS(i)-1);
        }

        System.out.println(max);
    }
    public static int LIS(int num){

        if(ansUp[num] == 0){

            ansUp[num] = 1;

            for(int i = num-1; i >= 0 ; i--){
                if(arr[num] > arr[i]){
                    ansUp[num] = Math.max(ansUp[num], LIS(i)+1);
                }

            }
        }
        return ansUp[num];
    }

    public static int LDS(int num){

        if(ansDown[num] == 0){

            ansDown[num] = 1;

            for(int i = num+1; i < ansDown.length ; i++){
                if(arr[num] > arr[i]) {
                    ansDown[num] = Math.max(ansDown[num], LDS(i) + 1);
                }
            }

        }
        return ansDown[num];
    }
}

