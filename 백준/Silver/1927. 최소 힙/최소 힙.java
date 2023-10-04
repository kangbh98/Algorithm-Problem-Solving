import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());


        int input;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());

            if (input>0) {
                pq.add(input);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.remove());
                }
                else{
                    System.out.println(0);
                }
        }
        }
    }
}