import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {

            int total = 1;
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();

            if (n == 0) {
                System.out.println(0);
                continue;
            }
            for (int k = 0; k < n; k++) {

                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String str = st.nextToken();

                if(map.containsKey(str)){
                    Integer get = map.get(str);
                    get++;
                    map.put(str, get);
                }else{
                    map.put(str, 1);
                    set.add(str);
                }
            }
            for (String s : set) {
                int parsedInt = map.get(s)+1;
                total*=parsedInt;
            }
            System.out.println(total-1);
        }

    }

}