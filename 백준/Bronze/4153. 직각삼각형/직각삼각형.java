import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int arr[] = new int[3];
            arr[0]= Integer.parseInt(st.nextToken());
            arr[1]= Integer.parseInt(st.nextToken());
            arr[2]= Integer.parseInt(st.nextToken());
            if(arr[0]+arr[1]+arr[2]== 0) return;
            Arrays.sort(arr);
            if(arr[2]*arr[2]==arr[0]*arr[0]+arr[1]*arr[1]){
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }

        }


    }
}