import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static class Node implements Comparable<Node>{
        int idx;
        int weigh;

        public  Node(int idx, int weigh) {
            this.idx = idx;
            this.weigh = weigh;
        }
        @Override
        public int compareTo(Node node){
            return this.weigh-node.weigh;
        }
    }
    static int n,m,start,end;
    static ArrayList<Node> map[];
    static int dist[];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 =Integer.parseInt(st.nextToken());
            int num2 =Integer.parseInt(st.nextToken());
            int num3 =Integer.parseInt(st.nextToken());

            map[num1].add(new Node(num2, num3));
        }

        st = new StringTokenizer(br.readLine());
        start =Integer.parseInt(st.nextToken());
        end =Integer.parseInt(st.nextToken());

        djikstra();
        System.out.println(dist[end]);
    }

    public static void djikstra(){

        boolean visited[] = new boolean[n+1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){

            Node node2= pq.remove();

            if(visited[node2.idx]) continue;
            visited[node2.idx] = true;

            for (Node node : map[node2.idx]) {

                if( dist[node.idx] > dist[node2.idx] + node.weigh){
                    dist[node.idx] = dist[node2.idx] + node.weigh;
                    pq.add(new Node(node.idx,dist[node.idx]));
                }

            }

        }

    }
}