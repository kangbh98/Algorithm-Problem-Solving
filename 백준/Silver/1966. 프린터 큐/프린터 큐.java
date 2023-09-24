import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            int arr2[] = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                int num =Integer.parseInt(st.nextToken());
                arr2[k]=num;
                queue.add(new int[]{k,num});
            }
            Arrays.sort(arr2);
            int count = N-1;

            while (!queue.isEmpty()){

                int[] front = queue.poll();
                if(front[1]==arr2[count]){
                    count--;
                    if(front[0]==m){
                        break;
                    }
                }else{
                    queue.add(front);
                }
            }
            System.out.println(N-1-count);
        }
    }

}