import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("\\-");
        int num = cal(split[0]);

        for (int i = 1; i < split.length; i++) {
            num -= cal(split[i]);
        }
        System.out.println(num);
    }
    public static int cal(String str){
        int num =0;
        String[] split = str.split("\\+");
        for (int i = 0; i < split.length; i++) {
            num+=Integer.parseInt(split[i]);
        }
        return num;
    }
}