import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    static int n;
    static int m;
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
       

        int arr2[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recursion(0,0,arr2);
    }

    public static void recursion(int depth, int start,int[] arr2) {

        if(depth==m){
            for(int i : arr2){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            arr2[depth] = arr[i];
            recursion(depth + 1, i, arr2);
        }
    }
}