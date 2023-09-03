import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import  java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       Queue<Integer> queue = new LinkedList<>();

        for (int i = 1 ; i < n+1 ; i++){
            queue.add(i);
        }

        while(queue.size()!=1){
            queue.remove();
            int i = queue.poll();
            queue.add(i);
        }
        System.out.println(queue.poll());
    }
}