import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
        static int exchange;
        static int Max =0;
        static char arr[];
        static boolean visited[];
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            arr = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }

            exchange = Integer.parseInt(st.nextToken());
            if (exchange>s.length()){
                exchange=s.length();
            }
            int depth = 0;
            Recursion(0,depth,arr);
            System.out.println("#" + test_case + " "+ Max);
            Max = 0;
        }
    }

    static void Recursion(int start,int depth,char[] arr) {

        if(depth==exchange){
            int calculate = Calculate(arr);
            if(calculate>Max){
                Max = calculate;
            }
            return;
        }

        for (int i = start; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                char load = arr[i];
                arr[i]=arr[j];
                arr[j]=load;
                Recursion(i,depth + 1, arr);
                arr[j] = arr[i];
                arr[i] = load;
            }
        }
    }

    static int Calculate(char[] arr){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
        }
        return Integer.parseInt(str.toString());
    }
}