import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    static int sdoku[][] = new int[9][9];
    static boolean flag = false;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 9 ; i++){
            String S = br.readLine();
            for(int j = 0 ; j < 9 ; j++){
                sdoku[i][j] = S.charAt(j)-'0';
            }
        }

        recursion(0);

    }
    public static void recursion(int depth){

        if(flag) return;

        if(depth == 81){
            for(int i = 0 ; i < 9 ; i++) {
                for(int j = 0 ; j < 9 ; j++){
                    System.out.print(sdoku[i][j]);
                }
                System.out.println();
            }
            flag = true;
            return;
        }

        int 몫 = depth/9;
        int 나머지 = depth%9;

        if(sdoku[몫][나머지] != 0) {
            recursion(depth+1);
        }else{
            boolean[] blArr = checkSdoku(몫,나머지);
            for(int i = 1 ; i < 10 ; i++){
                if(!blArr[i]){
                    sdoku[몫][나머지] = i;
                    recursion(depth+1);
                    sdoku[몫][나머지] = 0;
                }
            }
        }

    }
    public static boolean[] checkSdoku(int x, int y){

        boolean[] tf = new boolean[10];

        // 가로체크
        for(int j = 0 ; j < 9 ;j++){
            tf[sdoku[x][j]] = true;
        }
        // 세로체크
        for(int i = 0 ; i < 9 ;i++){
            tf[sdoku[i][y]] = true;
        }

        // 구역체크
        int i = x/3;
        int j = y/3;
        for(int a = 3*i ; a < 3*i+3 ; a++){
            for(int b = 3*j ; b< 3*j+3 ; b++){
                tf[sdoku[a][b]] = true;
            }
        }
        return tf;
    }
}