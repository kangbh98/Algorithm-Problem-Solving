import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static class Node{
        int 점수;
        int 시간;

        public Node(int 점수,int 시간) {
            this.점수 = 점수;
            this.시간 = 시간;
        }
    }

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        int totalScore = 0;


        while(n>0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());

            if(num1 == 0) {
                if(!stack.isEmpty()) {
                    Node node = stack.pop();
                    node.시간--;
                    if (node.시간 == 0) totalScore += node.점수;
                    else stack.push(node);
                }
            }else if(num1 == 1) {
                int 점수  =Integer.parseInt(st.nextToken());
                int 시간 = Integer.parseInt(st.nextToken());
                if(시간 == 1) totalScore += 점수;
                else stack.add(new Node(점수,시간-1));
            }
            n--;
        }

        System.out.println(totalScore);
    }
}