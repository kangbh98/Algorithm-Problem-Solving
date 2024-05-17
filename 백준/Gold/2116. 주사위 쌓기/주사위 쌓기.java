import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static int dice[][];
    public static int n,아랫면,윗면;
    public static long num[] = new long[7];
    public static int arr[] = {0,1,2,3,4,5,6};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dice = new int[n + 1][7];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 7; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 아랫면 정해짐
        for (int i = 1; i < 7; i++) {

             아랫면 = i;
            // 아랫면에 맞는 윗면 정하기
             윗면 = 윗면정하기(아랫면,1);
            // 최댓값 더하기 ( 윗면과 아랫면 아닌 값들중 최댓값)
            최댓값더하기(i,아랫면,윗면);

            for (int j = 2; j < n + 1; j++) {

                아랫면 = 윗면;
                윗면 = 윗면정하기(아랫면,j);
                최댓값더하기(i,아랫면,윗면);
            }
        }

        Arrays.sort(num);
        System.out.println(num[6]);
    }

    public static int 윗면정하기(int num,int index){

        int 아랫면위치 = 0;
        int 윗면위치 = 0;
        for(int i = 1 ; i < 7 ; i++){
            if(dice[index][i]== num){
                아랫면위치 = i;
            }
        }

        if( 아랫면위치 == 1){
            윗면위치 = 6;
        }else if( 아랫면위치 == 2){
            윗면위치 = 4;
        }else if( 아랫면위치 == 3){
            윗면위치 = 5;
        }else if( 아랫면위치 == 4){
            윗면위치 = 2;
        }else if( 아랫면위치 == 5){
            윗면위치 = 3;
        }else if( 아랫면위치 == 6){
            윗면위치 = 1;
        }

        return dice[index][윗면위치];
    }

    public static void 최댓값더하기(int num1,int 빠질값1,int 빠질값2){

        int max = 0;
        for(int i = 1 ; i < 7 ; i++ ){
            if(i== 빠질값1 || i == 빠질값2){
                continue;
            }
            max = i;
        }
        num[num1] += max;
    }
}