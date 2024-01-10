import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int test_case=0 ; test_case < T; test_case++ ) {


            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();


            if (N > 47) {
                System.out.println(0);
                continue;
            }
            
            String arr[] = new String[47];
            StringTokenizer st = new StringTokenizer(s);

            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }

            


            int ans = Integer.MAX_VALUE;


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {

                        if (i != j && j != k && i != k) {

                            int count =  0;

                            String a = arr[i];
                            String b = arr[j];
                            String c = arr[k];

                            for (int p = 0; p < 4; p++) {

                                if (a.charAt(p) != b.charAt(p)) {
                                    count++;
                                }
                                if (b.charAt(p) != c.charAt(p)) {
                                    count++;
                                }
                                if (a.charAt(p) != c.charAt(p)) {
                                    count++;
                                }
                            }

                            if(count < ans){
                                ans = count;
                            }
                        }

                    }
                }
            }
            System.out.println(ans);
        }
    }

}