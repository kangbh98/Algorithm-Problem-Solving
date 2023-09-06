import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        int max = k;
        st = new StringTokenizer(br.readLine());
        int print = 0;

        for( int i = 0 ; i < n ; i ++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1 ; j< n-1; j ++){
                for(int z = j+1 ; z<n ; z++){
                    int num = arr[i]+arr[j]+arr[z];
                    if(k>=num && max > k-num){
                        max = k-num;
                        print = num;
                    }
                }
            }
        }
        System.out.println(print);


    }

}
