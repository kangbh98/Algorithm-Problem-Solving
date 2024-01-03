import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int count = 1;

        Set<Long> set = new HashSet<Long>();
        Queue<Long> queue = new LinkedList();

        queue.add(a);

        while (!queue.isEmpty()) {

            int size = queue.size();
            count++;

            for (int i = 0; i <size;i++){
                long num =  queue.remove();

                long num1 = num * 2;
                long num2 = num* 10+1;

                if (num1 == b || num2 == b) {
                    System.out.println(count);
                    return;
                }

                if (!set.contains(num1)&& num1 <b) {
                    set.add(num1);
                    queue.add(num1);

                }

                if (!set.contains(num2) && num2<b) {
                    set.add(num2);
                    queue.add(num2);

                }
            }
        }
        System.out.println(-1);
    }
}