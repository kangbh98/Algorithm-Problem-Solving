import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[]= new int[1001];
        arr[0]=1;
        arr[1]=2;
        for(int k=2;k<n+1;k++){
            arr[k]=arr[k-1]+arr[k-2];
            arr[k]=arr[k]%10007;
        }
        System.out.println(arr[n-1]);
    }
}
