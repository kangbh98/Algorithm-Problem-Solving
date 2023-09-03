import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = Math.max(i,k);
        int min = Math.min(i,k);

        int z = uclid(max,min);
        System.out.println(z);
        System.out.println(z*(i/z)*(k/z));

    }
    public static int uclid(int max, int min ){
        int remain = 0;
        while(min!=0){
           remain =  max % min;
           max = min;
           min = remain;
        }
        return max;
    }

}
