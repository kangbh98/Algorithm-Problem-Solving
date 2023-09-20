import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int point = 0;
        int 수열 = 1;

        stack.push(수열);
        sb.append("+"+"\n");


        while(point != n){

            if(!stack.empty()&&stack.peek().equals(arr[point])){
                stack.pop();
                sb.append("-"+"\n");
                point++;
                continue;
            }
            수열++;
            if(수열>n+10) break;
            stack.push(수열);
            sb.append("+"+"\n");

        }

        if(point==n){
            System.out.println(sb);
        }else {
            System.out.println("NO");
        }


    }
}