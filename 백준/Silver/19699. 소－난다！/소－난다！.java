import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static int arr[];
    public static int n,m;
    public static TreeSet<Integer> list = new TreeSet<>();
    public static boolean primeNums[] = new boolean[9001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int ans[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 2 ; i <= 300 ; i++){
            if(!primeNums[i]){
                int num = i;
                while (true){
                    num += i ;
                    if(num <= 9000){
                        primeNums[num] = true;
                    }else {
                        break;
                    }
                }
            }
        }


        recursion(0,0,ans);

        for (int k : list){
            System.out.print(k+" ");
        }
        if (list.isEmpty()){
            System.out.println(-1);
        }
    }

    public static void recursion(int depth,int start, int[] ans){

        if(depth == m){
            check(ans);
//            System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
            return;
        }

        for(int i = start ; i < n ; i++){
            ans[depth] = arr[i];
            recursion(depth+1, i+1, ans);
        }

    }

    public static void check(int[] ans){

        int num = 0;
        for(int i : ans){
            num += i;
        }
        if(!primeNums[num]){
            list.add(num);
        }
    }
}