import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        sb.append("<");

        for(int i = 1 ; i <=N ;i++) {
            q.add(i);
        }

        while(q.size()>1) {
            if(count == K-1) {
                sb.append(q.poll() + ", ");
                count = 0;
            } else {
                q.add(q.poll());
                count++;
            }

        }

        sb.append(q.poll()+">");

        System.out.println(sb);

    }
}
