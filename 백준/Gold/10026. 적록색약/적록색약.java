import java.io.*;
import java.lang.*;
import java.util.*;

class RGB{
    int x;
    int y;
    public RGB(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main{

    public static char arr[][];
    public static boolean tf[][];
    public static int n;
    public static Stack<RGB> stack = new Stack<RGB>();
    public static int rCount = 0;
    public static int gCount = 0;
    public static int bCount = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n+1][n+1];
        tf = new boolean[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int k = 1; k <= n; k++) {
               arr[i][k] = str.charAt(k-1);
            }
        }

        Cal();
        System.out.print(rCount+gCount+bCount+" ");

        tf = new boolean[n+1][n+1];

        bCount = 0;
        rCount = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                if(arr[i][k]=='G'){
                    arr[i][k]= 'R';
                }
            }
        }
        Cal();
        System.out.print(rCount+bCount);
    }

    public static void Cal(){

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                if(!tf[i][k]){
                    if(arr[i][k]=='R'){
                        rCount++;
                    }else if(arr[i][k]=='G'){
                        gCount++;
                    }if(arr[i][k]=='B' ){
                        bCount++;
                    }
                    stack.push(new RGB(i,k));
                    Cal2();
                }
            }
        }
    }
    public static void Cal2() {

        while (!stack.empty()){

            int arr1[] =  { 0,0,-1,1};
            int arr2[] = { -1,1,0,0};

            RGB rgb = stack.pop();

            for (int i = 0; i < 4; i++) {
                int x = rgb.x+arr1[i];
                int y = rgb.y+arr2[i];

                if( (x>0 && x<=n) && (y>0 && y<=n) && !tf[x][y] && arr[rgb.x][rgb.y]==arr[x][y]){
                    stack.push(new RGB(x,y));
                    tf[x][y]=true;
                }
            }
        }
    }
}