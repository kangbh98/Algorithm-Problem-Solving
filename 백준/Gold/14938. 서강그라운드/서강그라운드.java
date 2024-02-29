import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    static class Node implements Comparable<Node>{
        int idx;
        int weigh;
        Node(int idx,int weigh){
            this.idx = idx;
            this.weigh = weigh;
        }

        @Override
        public int compareTo(Node node){
            return this.weigh - node.weigh;
        }
    }


    static int n,m,r;
    static int item[];
    static ArrayList<Node>[] list;
    static int ansTotal = -1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 둘째줄 입력
        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        // 간선 입력
        list = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            list[num1].add(new Node(num2, num3));
            list[num2].add(new Node(num1, num3));
        }

        // 각 지점 별로 아이템 최대 갯수 측정
        for (int i = 1; i < n + 1; i++) {
            djikstra(i);
        }
        System.out.println(ansTotal);
    }

    public static void djikstra(int start){

        // 각 지점별 아이템 갯수 값
         int itemNum = 0;

        // 방문 여부 배열 초기화
        boolean visited[] = new boolean[n + 1];

        // 거리측정 배열 초기화
        int dist[] = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        // 우선순위 큐 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        // 우선순위 큐 활용해서 경로값들 측정
        while (!pq.isEmpty()) {

            Node node1 = pq.remove();

            if(visited[node1.idx]) continue;
            visited[node1.idx] = true;

            for (Node node2 : list[node1.idx]) {
                if(dist[node2.idx] > dist[node1.idx] + node2.weigh){
                    dist[node2.idx] = dist[node1.idx] + node2.weigh;
                    pq.add(new Node(node2.idx, dist[node2.idx]));
                }
            }
        }

//        System.out.println("==========="+start+"=========");
//        for (int i = 1; i < n + 1; i++) {
//            System.out.print(dist[i] + " ");
//        }
//        System.out.println("==========="+start+"=========");
//        System.out.println();

        for (int i = 1; i < n + 1; i++) {
            if(dist[i]<=m) itemNum += item[i];
        }
        ansTotal = Math.max(ansTotal, itemNum);
    }
}