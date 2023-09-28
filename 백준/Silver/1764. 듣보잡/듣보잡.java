import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int count = 0;

        for ( int i = 0 ; i < n ; i++){
            map.put(br.readLine(), 1);
        }
        for ( int i = 0 ; i < m ; i++){
            list.add(br.readLine());
        }
        Collections.sort(list);

        for ( int i = 0 ; i < m ; i++){
            String str = list.get(i);
            if(map.containsKey(str)){
                sb.append(str+"\n");
                count++;
            }
        }


        System.out.println(count);
        System.out.print(sb);
    }
}