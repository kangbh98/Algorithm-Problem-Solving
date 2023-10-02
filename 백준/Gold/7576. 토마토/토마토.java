import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static int m;
    public static int n;
    public static int arr[][];
    public static boolean tf[][];
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        tf = new boolean[n+1][m+1];
        int total = 0;

        for (int i = 1 ; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= m; k++){
                arr[i][k]= Integer.parseInt(st.nextToken());
                if(arr[i][k]==1){
                    queue.add(i);
                    queue.add(k);
                }
            }
        }
        if(queue.size()== 2*m*n) {
            System.out.println(0);
            return;
        }else if (queue.size()==0) {
            System.out.println(-1);
            return;
        }else {
            int count = queue.size()/2;

            while(!queue.isEmpty()){
                int num1 = queue.remove();
                int num2 = queue.remove();
                if(!tf[num1][num2]){
                    Cal(num1,num2);
                }
                count--;
                if(count==0){
                    count=queue.size()/2;
                    total++;
                }
            }
        }

        for (int i = 1 ; i <= n; i++) {
            for (int k = 1; k <= m; k++){
                if(arr[i][k]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(total-1);
    }

    public static void Cal(int num1, int num2) {

        tf[num1][num2] = true;
        int[] int1 = {0, 0, -1, 1};
        int[] int2 = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {

            int num1x = num1+int1[i];
            int num2x = num2+int2[i];
            if( (num1x>0 && num1x<n+1)&& (num2x>0 && num2x<m+1)&&!tf[num1x][num2x]&&arr[num1x][num2x]==0){
                arr[num1x][num2x]=1;
                queue.add(num1x);
                queue.add(num2x);
            }
        }
    }
}