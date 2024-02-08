import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static ArrayList<Integer> list = new ArrayList<>();
    static int m;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean tf[] = new boolean[10001];

        // 첫번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int arr[] = new int[m];

        // 두번째 줄 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int num =Integer.parseInt(st.nextToken());
            if(!tf[num]){
                list.add(num);
                tf[num] =true;
            }
        }
        Collections.sort(list);

        recursion(arr, 0,0);
    }

    public static void recursion(int[] arr ,int depth,int start){

        if(depth == m){
            for(int i :arr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i< list.size();i++){
            arr[depth] = list.get(i);
            recursion(arr, depth + 1,i);
        }
    }

}

