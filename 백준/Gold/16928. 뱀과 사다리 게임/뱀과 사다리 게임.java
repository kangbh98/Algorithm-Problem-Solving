import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    public static int arr[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        n += Integer.parseInt(st.nextToken());
        arr= new int[n][2];

        boolean tf[] = new boolean[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        tf[1] = true;
        int count = 0;

        while(true){

            count++;
            int size = queue.size();
            int count2 = 0;

            while(count2 < size){
                count2++;
                Integer remove = queue.remove();

                if(remove+1 <= 100 && !tf[remove+1]){
                    tf[remove+1]=true;
                    queue.add(checkSnakeLadder(remove+1));

                }
                if(remove+2 <= 100 && !tf[remove+2]){
                    tf[remove+2]=true;
                    queue.add(checkSnakeLadder(remove+2));

                }
                if(remove+3 <= 100 && !tf[remove+3]){
                    tf[remove+3]=true;
                    queue.add(checkSnakeLadder(remove+3));

                }
                if(remove+4 <= 100 && !tf[remove+4]){
                    tf[remove+4]=true;
                    queue.add(checkSnakeLadder(remove+4));

                }
                if(remove+5 <= 100 && !tf[remove+5]){
                    tf[remove+5]=true;
                    queue.add(checkSnakeLadder(remove+5));

                }
                if(remove+6 <= 100 && !tf[remove+6]){
                    tf[remove+6]=true;
                    queue.add(checkSnakeLadder(remove+6));

                }

                if (tf[100]) {
                    System.out.println(count);
                    return;
                }

            }
        }
    }

    public static int checkSnakeLadder(int num){
        for (int i = 0; i < arr.length; i++) {
            if( num == arr[i][0]){
                return arr[i][1];
            }
        }
        return num;
    }
}