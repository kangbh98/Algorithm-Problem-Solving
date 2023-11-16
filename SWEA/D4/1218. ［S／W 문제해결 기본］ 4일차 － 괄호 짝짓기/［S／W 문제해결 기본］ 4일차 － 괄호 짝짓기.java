
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


class Solution
{

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            Stack<Character> stack = new Stack<>();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            for (int i = 0; i < n; i++) {
                char chars = str.charAt(i);

                if(chars==')'){
                    if(stack.peek()=='('){
                        stack.pop();
                    }else {
                        break;
                    }
                } else if (chars==']') {
                    if(stack.peek()=='['){
                        stack.pop();
                    }else {
                        break;
                    }
                } else if (chars=='}') {
                    if(stack.peek()=='{'){
                        stack.pop();
                    }else {
                        break;
                    }
                } else if (chars=='>') {
                    if(stack.peek()=='<'){
                        stack.pop();
                    }else {
                        break;
                    }
                }else {
                    stack.push(chars);
                }
            }
            if (stack.size()==0){
                System.out.println("#"+test_case+" "+1);
            }else {
                System.out.println("#"+test_case+" "+0);
            }
        }
    }
}