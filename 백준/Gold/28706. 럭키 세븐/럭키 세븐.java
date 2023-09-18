import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

        for (int i = 0 ; i < t ; i++ ){

            int n = Integer.parseInt(br.readLine()); //테스트 케이스 턴 갯수
            boolean arr[][] = new boolean[n][7]; //

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = turn_cal(1,st.nextToken(),st.nextToken());
            int b = turn_cal(1,st.nextToken(), st.nextToken());
            arr[0][a%7]=true;
            arr[0][b%7]=true;

            for (int k = 1; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                String s3 = st.nextToken();
                String s4 = st.nextToken();

                for(int j = 0 ; j < 7 ; j++){
                    if(arr[k-1][j]==true){
                        a = turn_cal(j,s1,s2);
                        b = turn_cal(j,s3,s4);
                        arr[k][a%7]=true;
                        arr[k][b%7]=true;
                    }
                }
            }
            if(arr[n-1][0]==true){
                System.out.println("LUCKY");
            }else{
                System.out.println("UNLUCKY");
            }
        }

    }

    static int turn_cal(int a, String b, String c){
        if(b.equals("+")){
            return a+Integer.parseInt(c);
        }else{
            return a*Integer.parseInt(c);
        }
    }


}