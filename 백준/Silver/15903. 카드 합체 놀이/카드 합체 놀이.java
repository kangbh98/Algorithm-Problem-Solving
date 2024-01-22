import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    static class node implements Comparable<node>{
        Long x;

        public node(Long x) {
            this.x = x;
        }

        @Override
        public int compareTo(node o) {
            return Long.compare(this.x, o.x);
        }
    }

    static long total=0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<node> arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayList.add(new node(Long.parseLong(st.nextToken())));
        }

        Collections.sort(arrayList);



        for (int i = 0; i < m; i++) {
            Long remove1 = arrayList.remove(0).x;
            Long remove2 = arrayList.remove(0).x;
            arrayList.add(new node(remove1 + remove2));
            arrayList.add(new node(remove1 + remove2));
            Collections.sort(arrayList);
        }

        for (node i : arrayList) {
            total += i.x;
        }

        System.out.println(total);

    }


}