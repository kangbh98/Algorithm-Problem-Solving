import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


public class Main {

    static class Node{
        int idx,cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int v,e,start;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] dist;
    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dist = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();


            for (int i = 0; i < graph.get(temp.idx).size(); i++) {
                Node next = graph.get(temp.idx).get(i);
                if (dist[next.idx] > temp.cost + next.cost) {
                    dist[next.idx] = temp.cost + next.cost;
                    queue.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }


        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}