import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n;
    static int arr[];
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2,n)];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        recursion(0,1,arr.length-1);

        for(ArrayList<Integer> arr : list){
            for(Integer i : arr ){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void recursion(int depth,int first,int end){

        if(depth == n){
            return;
        }

        int mid = (first+end)/2 ;
        list.get(depth).add(arr[mid]);

        recursion(depth+1,first,mid-1);
        recursion(depth+1,mid+1,end);
    }
}

