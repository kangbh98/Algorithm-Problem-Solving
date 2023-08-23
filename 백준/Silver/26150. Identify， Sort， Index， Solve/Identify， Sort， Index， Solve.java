import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String arr[][] = new String[N][3];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < 3; k++) {
                arr[i][k] = in.next();
            }
        }
        Arrays.sort(arr, new Comparator<String[]>() { 
            @Override
            public int compare(String[] o1, String[] o2) { 
                return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
            }
        });
        for (int a = 0; a < N; a++) {
            char k = arr[a][0].charAt(Integer.parseInt(arr[a][2])-1) ;
            char UpperCh =Character.toUpperCase(k);
            System.out.print(UpperCh);
            }
        }
}