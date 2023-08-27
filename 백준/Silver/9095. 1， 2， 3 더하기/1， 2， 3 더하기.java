import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[15];
        arr[0]=1;
        arr[1]=2;
        arr[2]=4;
        for(int i = 0 ; i < n ; i++){
            int T_case = Integer.parseInt(br.readLine());
            for(int k = 3 ; k < T_case ; k++){
                    arr[k]=arr[k-1]+arr[k-2]+arr[k-3];
            }
            System.out.println(arr[T_case-1]);
        }
    }
}