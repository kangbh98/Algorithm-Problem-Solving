import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        int arr[]=new int[n];
        int sum_arr[]=new int[n+1];
        for(int i=0; i < n ;i++){
            arr[i]=in.nextInt();
        }
        for(int k=0;k<n;k++){
            sum+=arr[k];
            sum_arr[k+1]=sum;
        }
        sum_arr[0]=0;

        for(int a=0;a<m;a++){
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(sum_arr[j]-sum_arr[i-1]);
        }
    }
}