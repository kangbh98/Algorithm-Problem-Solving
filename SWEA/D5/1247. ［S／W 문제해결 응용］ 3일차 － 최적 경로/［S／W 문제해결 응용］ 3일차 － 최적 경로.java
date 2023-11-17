import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


class Solution
{
    static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean visited[];
    static node 구하기[];
    static int n;
    static ArrayList<Integer> arrayList = new ArrayList<>();


    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            visited = new boolean[n+2];
            node array[] = new node[n+2];
            구하기 = new node[n+2];

            array[0] =new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            구하기[0] =array[0];
            array[n+1] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            구하기[n+1] = array[n+1];
            구하기 = new node[n+2];
            for (int i = 1; i < n+1; i++) {
                구하기[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            int depth =1;
            recursion(depth,array);
            Collections.sort(arrayList);
            System.out.println("#"+test_case+" "+arrayList.get(0));
            arrayList.clear();
        }
    }

    static void recursion(int depth,node[] array) {
        if (depth == n+1) {
            arrayList.add(Calculate(array));
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = 구하기[i];
                recursion(depth+1,array);
                visited[i]=false;
            }
        }
    }

    static int Calculate(node[] array) {
        int total = 0;
        for (int i = 1; i < n + 2; i++) {
            total+= Math.abs(array[i-1].x-array[i].x)+Math.abs(array[i-1].y-array[i].y);
        }
        return total;
    }
}