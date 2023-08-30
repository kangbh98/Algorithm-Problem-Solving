import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                if(stack.empty()) continue;
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        int total = 0 ;
        while (!stack.empty()) {  // 수정: 스택이 비어있을 때까지 루프 돌기
            total = total + stack.peek();
            stack.pop();
        }
        System.out.println(total);
    }
}