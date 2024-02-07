import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }

        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if( num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.remove());
                }
            }else {
                pq.add(num);
            }
        }
    }
}