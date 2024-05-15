import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)arr[i] = sc.nextInt();
        List<Integer> sum = new ArrayList<>();
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N; j++){
                sum.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(sum);

        for (int i = N-1; i>=0; i--){
            for (int j = N-1; j>=0; j--){
                int minus = arr[i] - arr[j];

                if (Collections.binarySearch(sum,minus)>=0){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}