import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());  //첫줄
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()); //둘쨰줄 입력
        HashMap<Integer,Integer> map = new HashMap<>();

        for( int i = 0 ; i < m ; i++) {

            int a = Integer.parseInt(st.nextToken());

            if (map.containsKey(a)){
                int b = map.get(a);
                b++;
                map.put(a,b);
            }else{
                map.put(a,1);
            }
        }

        int n = Integer.parseInt(br.readLine()); // 셋쨰줄입력
        st = new StringTokenizer(br.readLine()); // 넷쨰줄 입력

        for ( int i =0 ; i < n ; i++){

            int a = Integer.parseInt(st.nextToken());

            if (map.containsKey(a)){
                sb.append(map.get(a)+" ");
            }else sb.append(0+" ");
        }

        System.out.println(sb);

    }
}
