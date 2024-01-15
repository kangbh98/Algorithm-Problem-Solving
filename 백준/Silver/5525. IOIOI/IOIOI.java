import java.util.*;
import java.io.*;
import java.lang.*;


public class Main{

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char arr[] = new char[m];
        char pNarr[] = new char[1+2*n];

        for (int i = 0; i < m; i++) {
            arr[i] = s.charAt(i);
        }

        pNarr[0] = 'I';
        for (int i = 1; i < pNarr.length; i++) {

            if (i % 2 == 1) {
                pNarr[i] = 'O';
            }else {
                pNarr[i] = 'I';
            }
        }

        int flag = 0;
        int count = 0;
        while (flag < m +1 - pNarr.length) {
            char c = arr[flag];

            if(c=='O'){
                flag++;
                continue;
            }else {
                boolean tf = true;
                for (int i = 1; i < pNarr.length; i++) {
                    if(arr[flag+i] != pNarr[i]){
                           tf = false;
                    }
                }
                if(tf == true){
                    count++;
                    flag+=2;
                    continue;
                }
                flag++;
            }
        }
        System.out.println(count);
    }
}