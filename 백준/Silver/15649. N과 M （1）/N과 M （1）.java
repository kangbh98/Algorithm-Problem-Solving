import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static int arr[];
    public static boolean tf[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        arr = new int[m+1];
        tf = new boolean[n+1];// 숫자와 배열 위치를 일치 시키기 위해서 1 크게 배열을 설정해줍니다.

        recursion(n,m,count);
    }

    public static void recursion(int n, int m,int count){

        if(count==m){
            for (int i = 1; i <= m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {

            if(!tf[i]){ //해당 노드를 방문하지 않은 경우

                tf[i]=true; // 해당 노드를 방문 상태로 변경
                arr[count+1]=i;
                recursion(n,m,count+1); //자식 노드로 들어가므로 count를 1 증가 시킨다.
                tf[i] = false; // 자식노드에서 더 이상 해결책이 없으므로 현재 노드 값을 변경시켜 탐색하기 위해 tf[i]를 참으로 변경
            }
        }
    }
}