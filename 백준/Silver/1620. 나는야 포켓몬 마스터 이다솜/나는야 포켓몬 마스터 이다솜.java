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
        HashMap<String,Integer> str_map = new HashMap<>();
        HashMap<Integer,String> num_map = new HashMap<>();

        for ( int i = 0 ; i < n ; i++){
            String str = br.readLine();
            str_map.put(str,i+1);
            num_map.put(i+1,str);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(str.charAt(0)>64){
                System.out.println(str_map.get(str));
            }else {
                System.out.println(num_map.get(Integer.parseInt(str)));
            }
        }


    }
}