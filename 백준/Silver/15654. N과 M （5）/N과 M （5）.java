import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    static int n;
    static int m;
    static int arr[];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] ints = new int[m];
        boolean tf[]= new boolean[n];

        cal(0,ints,tf);
    }

    public static void cal(int depth,int[] ints,boolean[] tf) {

        if(depth == m){
            for( int i : ints){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {

            if(!tf[i]){
                tf[i] = true;
                ints[depth]=arr[i];
                cal(depth + 1,ints,tf);
                tf[i] = false;
            }

        }
    }
}