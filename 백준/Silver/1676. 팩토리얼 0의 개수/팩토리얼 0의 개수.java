import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = 0;


        while (n > 0) {

            int num = n;

            while (num % 5 == 0) {
                t++;
                num /= 5;
            }
            n -- ;
        }

        System.out.println(t);
    }
}