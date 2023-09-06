import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int z = n-k;


        for( int i = n-1 ; i > 0 ; i --){
            n*=i;
        }
        for( int i = k-1 ; i > 0 ; i --){
            k*=i;
        }
        for( int i = z-1 ; i > 0 ; i --){
            z*=i;
        }
        if(k==0) System.out.println(n/z);
        else if(z==0) System.out.println(n/(k));
        else System.out.println(n/(k*z));


    }

}
