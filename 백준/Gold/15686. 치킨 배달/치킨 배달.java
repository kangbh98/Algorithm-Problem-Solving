import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int total = Integer.MAX_VALUE;
    
    static ArrayList<node> 치킨집 = new ArrayList<>();
    static boolean tf[];
    static ArrayList<node> 집 = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int arr[][] =new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    집.add(new node(i, j));
                } else if (arr[i][j]==2) {
                    치킨집.add(new node(i, j));
                }
            }
        }
        int depth = 0;
        node select[] = new node[m];
        tf = new boolean[치킨집.size()];
        recursion(0,depth,select);
        System.out.println(total);
    }

    static void recursion(int c,int depth, node[] select) {

        if (depth == m) {
            total = Math.min(total,Calculate(select));
            return;
        }

        for (int i = c; i < 치킨집.size(); i++) {
            if (!tf[i]) {
                tf[i] = true;
                select[depth] = 치킨집.get(i);
                recursion(i, depth + 1, select);
                tf[i] = false;
            }
        }
    }

    static int Calculate(node[] select){
        int total = 0;

        for (node node : 집) {
            int min = Integer.MAX_VALUE;
            for (node node1 : select) {
                int i = Math.abs(node.x - node1.x) + Math.abs(node.y - node1.y);
                min = Math.min(i,min);
            }
            total += min;
        }
        return total;
    }
}
