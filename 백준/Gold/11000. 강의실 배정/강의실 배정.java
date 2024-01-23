import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        int Max_Size = 1;
        int size;
        pq.add(arr[0][1]);

        for (int i = 1; i < n; i++) {

            if(arr[i][0]>=pq.peek()){
                pq.poll();
            }
            pq.add(arr[i][1]);
            size = pq.size();
            if(Max_Size <size){
                Max_Size = size;
            }

        }

        System.out.println(Max_Size);


    }
}