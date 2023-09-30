import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int total = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stack.push(Integer.parseInt(st.nextToken()));
        }

        while(!stack.empty() && k!=0){

            int num = stack.pop();
            int num2 = k/num;
            if (num2 > 0) {
                k -= num2*num;
                total+=num2;
            }

        }
        System.out.println(total);
    }
}