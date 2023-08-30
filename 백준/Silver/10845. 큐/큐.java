import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<java.lang.Integer> queue = new ArrayDeque<>();
        int k = 0;

        for ( int i = 0 ; i < n ; i++){

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String str1 = st.nextToken();
            if(str1.equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(queue.peek());
            }
            if(str1.equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(k);
            }
            if(str1.equals("size")){
                System.out.println(queue.size());
            }
            if(str1.equals("empty")){
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            if(str1.equals("pop")){
                if (queue.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                 System.out.println(queue.poll());
            }
            if(str1.equals("push")){
                k =Integer.parseInt(st.nextToken());
                queue.add(k);
            }
        }
    }
}