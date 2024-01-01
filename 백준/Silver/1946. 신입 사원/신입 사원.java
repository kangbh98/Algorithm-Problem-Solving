import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][2];

            for (int k = 0; k < N; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[k][0]= Integer.parseInt(st.nextToken());
                arr[k][1]= Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            int min = arr[0][1];
            int count = 0;

            for (int k = 0; k < N; k++) {
                if(arr[k][1]<=min){
                    count++;
                    min = arr[k][1];
                }
            }
            System.out.println(count);
        }
    }
}