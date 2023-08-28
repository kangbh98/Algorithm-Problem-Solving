import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("top")) {
                if (stack.empty()) System.out.println(-1);
                else System.out.println(stack.peek());
            } else if (str.equals("size")) {
                System.out.println(stack.size());
            } else if (str.equals("empty")) {
                if (stack.empty()) System.out.println(1);
                else System.out.println(0);
            } else if (str.equals("pop")) {
                if (stack.empty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else { // str.equals("push")
                int k = Integer.parseInt(st.nextToken());
                stack.push(k);
            }
        }
    }
}