import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push_back")){
                deque.addLast(st.nextToken());
            }
            else if(str.equals("push_front")){
                deque.addFirst(st.nextToken());
            }
            else if(str.equals("pop_front")){
                if(deque.isEmpty()) {
                    System.out.println(-1);
                }else {
                    String str1 = deque.removeFirst();
                    System.out.println(str1);
                }
            }
            else if(str.equals("pop_back")){
                if(deque.isEmpty()) {
                    System.out.println(-1);
                }else {
                    String str1 = deque.removeLast();
                    System.out.println(str1);
                }
            }
            else if(str.equals("size")){
                System.out.println(deque.size());
            }
            else if(str.equals("empty")){
                if(deque.isEmpty()) {
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }
            else if(str.equals("front")){
                if(deque.isEmpty()) {
                    System.out.println(-1);
                }else {
                    String first = deque.getFirst();
                    System.out.println(first);
                }
            }
            else if(str.equals("back")){
                if(deque.isEmpty()) {
                    System.out.println(-1);
                }else {
                    String last = deque.getLast();
                    System.out.println(last);
                }
            }
        }



    }
}
