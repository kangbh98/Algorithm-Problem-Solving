import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            Stack<Character> stack =new Stack<>();

            String str = br.readLine();

            if(str.equals(".")) return; //  .을 입력하면 종료됩니다.

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                try{
                    if (ch == '(') {
                        stack.push(')');
                    } else if (ch == '[') {
                        stack.push(']');
                    } else if (ch ==']'||ch==')') {
                        if(stack.pop()!=ch){
                            System.out.println("no");
                            break;
                        }
                    }
                }catch (EmptyStackException e){
                    System.out.println("no");
                    break;
                }
                if(i==str.length()-1){
                    if(!stack.empty()){
                        System.out.println("no");
                        break;
                    }
                    System.out.println("yes");
                }
            }
        }

    }
}