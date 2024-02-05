import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static class Node implements Comparable<Node>{
        int index;
        int 값;

        public Node(int index, int 값){
            this.index = index;
            this.값 = 값;
        }

        @Override
        public int compareTo(Node n){
            return this.값-n.값;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node n3 : pq){
            System.out.println(n3.값 + " " + n3.index);
        }

        pq.add(new Node(1, arr[1]));
        arr[1] = 0;

        for (int i = 2; i < n+1; i++) {
            int num1 = arr[i];
            while (!pq.isEmpty()) {

                Node node = pq.remove();
                if(node.값>=num1){
                    arr[i] = node.index;
                    pq.add(node);
                    break;
                } else if (node.값 < num1) {
                }
            }
            if(pq.isEmpty()){
                arr[i] = 0;
            }
            pq.add(new Node(i, num1));
//            for(Node n3 : pq){
//                System.out.println(n3.값 + " " + n3.index);
//            }
//            System.out.println(arr[i]);
//            System.out.println();
        }

        for (int i = 1; i < n+1; i++) {
            sb.append(arr[i]+" ");
        }
        System.out.print(sb);
    }
}