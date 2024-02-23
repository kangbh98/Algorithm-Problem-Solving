import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static int n;
    static int 결과[][];
    static boolean 타순tf[];
    static int 최대점수 = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        결과 = new int[n][10];
        int 타순[] = new int[10];
        타순tf = new boolean[10];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                결과[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(타순, 1);

        System.out.println(최대점수);
    }

    public static void recursion(int[] 타순,int depth){

        if(depth==10 && 타순[4]==1){
//            for(int i = 1; i < 10; i++){
//                System.out.print(타순[i]+" ");
//            }
//            System.out.println();

            baseball(타순);
            return;
        }

        for (int i = 1; i < 10; i++) {


            if(!타순tf[i]){
                타순tf[i] = true;
                타순[depth] = i;
                recursion(타순, depth + 1);
                타순tf[i] = false;
            }
        }
    }

    public static void baseball(int[] 타순){

        int 타석번호 = 1;
        int 이닝 = 0;
        int 점수 = 0;

        while(이닝<n) {

            int 아웃카운트 = 0;
            int 루123[] = new int[4];

            while(아웃카운트<3){

                int 타자 = 타순[타석번호];
                int 결과번호 = 결과[이닝][타자];

                if(결과번호 ==0 ){
                    아웃카운트++;
                } else if (결과번호 == 1){
                    for(int i = 3 ; i >= 1 ; i--){
                        if(루123[i]!=0){
                            루123[i] = 0;
                            if(i+1>3) 점수++;
                            else 루123[i+1] = 1;
                        }
                    }
                    루123[1] = 1;

                } else if (결과번호 == 2) {

                    for(int i = 3 ; i >= 1 ; i--){
                        if(루123[i]!=0){
                            루123[i] = 0;
                            if(i+2>3) 점수++;
                            else 루123[i+2] = 1;
                        }
                    }
                    루123[2] = 1;

                } else if (결과번호 == 3) {

                    for(int i = 3 ; i >= 1 ; i--){
                        if(루123[i]!=0){
                            루123[i] = 0;
                            if(i+3>3) 점수++;
                            else 루123[i+3] = 1;
                        }
                    }
                    루123[3] = 1;
                } else if (결과번호 == 4) {
                    for(int i = 3 ; i >= 1 ; i--){
                        if(루123[i]!=0){
                            루123[i] = 0;
                            if(i+4>3) 점수++;
                            else 루123[i+4] = 1;
                        }
                    }
                    점수++;
                }

                타석번호++;
                if(타석번호==10) 타석번호 = 1;
            }
            이닝++;
        }

        최대점수 = Math.max(최대점수, 점수);
    }
}