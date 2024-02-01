import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char arr[] = new char[s];
        int 기준[] = new int[27];

        for (int i = 0; i < s; i++) {
            arr[i] = str.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        기준[0] = Integer.parseInt(st.nextToken());
        기준[2] = Integer.parseInt(st.nextToken());
        기준[6] = Integer.parseInt(st.nextToken());
        기준[19] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            char c = arr[i];
            기준[c-'A']--;
        }


        int count = 0;
        int index = p;

        if( 기준[0] < 1 && 기준[2] < 1 && 기준[6] < 1 && 기준[19] < 1){
            count++;
        }

        while(index<s){



            char c2 = arr[index];
            char c1 = arr[index-p];
            기준[c2-'A']--;
            기준[c1-'A']++;

            if( 기준[0] < 1 && 기준[2] < 1 && 기준[6] < 1 && 기준[19] < 1){
                count++;
            }

            index++;

        }


        System.out.println(count);

    }
}

