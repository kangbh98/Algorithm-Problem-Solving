import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[41][2];
        arr[0][0]= 1; arr[0][1]=0;
        arr[1][0]= 0; arr[1][1]=1;
        for( int i = 0 ; i < n ; i++){
            int t_case = Integer.parseInt(br.readLine());
            for( int k=2 ; k <= t_case ; k++){
                arr[k][0] = arr[k-2][0] + arr[k-1][0];
                arr[k][1] = arr[k-2][1] + arr[k-1][1];
            }
            System.out.println(arr[t_case][0]+" "+arr[t_case][1]);
        }
    }
}