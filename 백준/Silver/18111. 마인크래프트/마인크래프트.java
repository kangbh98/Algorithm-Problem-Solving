import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b=  Integer.parseInt(st.nextToken());
        int [][]arr = new int[n][m];
        int max_num = 0;
        int min_num = 257;

        for( int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k < m ; k ++){

                int p =Integer.parseInt(st.nextToken());
                arr[i][k]=p;

                if(p<min_num) min_num=p;
                else if (p>max_num) max_num=p;
            }
        }

        int min_time = 1000000000;
        int block = 0;

        for (int i = min_num ; i < max_num+1; i++){

            int time = 0;
            int bag = b;
            // 시간 구하기 시작
            for(int k = 0 ; k < n ; k++){
                for(int z = 0 ; z < m ; z++){

                    int num = arr[k][z];

                    if( num > i){
                        bag += num-i;
                        time+= 2*(num-i);
                    } else if (num < i) {
                        bag -=  i-num;
                        time += i-num;
                    }
                }
            }
            if(bag<0){}
            else if( time <= min_time){
                min_time=time;
                block = i;
            }
        }

        System.out.println(min_time+" "+block);



    }

}
