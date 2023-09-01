import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long count = 0;
        int total = 0;
        int[] cnt = new int[1001];

        StringTokenizer st2 = new StringTokenizer(br.readLine());


        for(int i = 0 ; i < n ; i++){

            int k =Integer.parseInt(st2.nextToken());
            total += k;
            total %= m;
            count += cnt[total];
            cnt[total]++;
            if(total==0)  count++;

        }
        System.out.println(count);
    }
}