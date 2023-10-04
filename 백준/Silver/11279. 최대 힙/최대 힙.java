import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


        int input;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());

            if(input==0){
                if(queue.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(queue.remove());
                }
            }else{
                queue.add(input);
            }
        }
    }
}