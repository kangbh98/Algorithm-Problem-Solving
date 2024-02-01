import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n;
    static boolean 소수판정[];
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        recursion(0,0);

        System.out.println(sb);
    }

    public static void recursion(int depth,int num){

        if(depth==n){
            sb.append(num).append("\n");
            return;
        }

        for(int i =0 ; i <10 ; i++){

            int nextNum = num * 10 + i;
            if(cal(nextNum)){
                recursion(depth + 1, nextNum);
            }

        }
    }

    public static boolean cal(int nextNum){
        if(nextNum<2){
            return false;
        }

        for (int i = 2; i * i <= nextNum; i++) {
            if(nextNum % i==0){
                return false;
            }
        }
        return true;
    }
}

