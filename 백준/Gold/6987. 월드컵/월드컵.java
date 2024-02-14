
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int arr[][];

    static boolean flag;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 4; t++) {

            arr = new int [6][3];
            flag = false;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 6; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            int ans[][] = new int[6][3];

            recursion(0,ans,0,0);
            if(!flag){
                System.out.print(0+" ");
            }else{
                System.out.print(1+" ");
            }
        }
    }

    public static void recursion(int depth,int[][] ans,int i,int j){

        if(depth == 15){
          cal(ans);
          return;
        }

        if(i==j){
            if(j==5){
                recursion(depth,ans,i+1,i+2);
            }else {
                recursion(depth,ans,i,j+1);
            }
        }else if(i!=j){
            if(j==5){
                ans[i][0] += 1;
                ans[j][2] += 1;
                recursion(depth+1,ans,i+1,i+2);
                ans[i][0] -= 1;
                ans[j][2] -= 1;

                ans[i][2] += 1;
                ans[j][0] += 1;
                recursion(depth+1,ans,i+1,i+2);
                ans[i][2] -= 1;
                ans[j][0] -= 1;

                ans[i][1] += 1;
                ans[j][1] += 1;
                recursion(depth+1,ans,i+1,i+2);
                ans[i][1] -= 1;
                ans[j][1] -= 1;

            } else if (j < 5) {

                ans[i][0] += 1;
                ans[j][2] += 1;
                recursion(depth+1,ans,i,j+1);
                ans[i][0] -= 1;
                ans[j][2]-= 1;

                ans[i][2] += 1;
                ans[j][0] += 1;
                recursion(depth+1,ans,i,j+1);
                ans[i][2] -= 1;
                ans[j][0] -= 1;

                ans[i][1] += 1;
                ans[j][1] += 1;
                recursion(depth+1,ans,i,j+1);
                ans[i][1] -= 1;
                ans[j][1] -= 1;
            }
        }
    }



    public static void cal(int[][] ans){
//

        for (int i = 0; i < 6; i++) {
//          System.out.println(ans[i][0]+" "+ans[i][1]+" "+ans[i][2]);
            if(ans[i][0] != arr[i][0] || ans[i][1]!=arr[i][1] || ans[i][2]!=arr[i][2]){
               return;
            }
        }
        flag = true;
    }
}