import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // 각각 테스트 케이스

        for(int i=0;i<t;i++){ //테스트 케이스를 반복해준다
            int n = in.nextInt(); //순열 길이 N
            int arr[]= new int[n];
            for(int k=0;k<n;k++){
                arr[k]=in.nextInt();
            }
            int prev_value=0;
            for(int z=0;z<n;z++){
                int max = Math.max(arr[z], (n - arr[z] + 1));
                int min = Math.min(arr[z],(n - arr[z] + 1));
                if(min >=prev_value){
                    prev_value=Math.min(arr[z],(n-arr[z]+1));
                }
                else if(max >=prev_value){
                    prev_value=Math.max(arr[z],(n-arr[z]+1));
                }
                else{
                    System.out.println("NO");
                    break;
                }
                if(z==n-1){
                    System.out.println("YES");
                }
            }
        }
    }
}
