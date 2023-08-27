import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ;; i++){
            int num = i;
            String str = Integer.toString(i);
            for(int k = 0 ; k < str.length() ; k++){
                num += str.charAt(k)-'0';
            }
            if(num == n){
                System.out.println(i);
                break;
            } else if (i>n) {
                System.out.println(0);
                break;
            }
        }
    }
}
