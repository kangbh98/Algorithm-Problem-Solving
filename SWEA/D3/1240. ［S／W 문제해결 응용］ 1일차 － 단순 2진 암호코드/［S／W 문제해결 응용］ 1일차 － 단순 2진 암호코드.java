import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            int x = 0;
            int y = 0;
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                String st = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = st.charAt(j)-'0';
                    if (arr[i][j]==1){
                        x = i;
                        y = j;
                    }
                }
            }

            String str_arr[]  = new String[10];
            String str12 = "";
            int b =1;
            for (int k = y - 55; k <= y; k++) {

                str12 = str12+arr[x][k];
                if (str12.length() == 7) {
                    str_arr[b] = str12;
                    b++;
                    str12="";
                }
            }
            int plus =0;
            int just_total=0;
            int total=0;
            for (int f = 1; f < 9; f++) {
                if(f%2==0){
                    plus = 1;
                }else {
                    plus = 3;
                }

                if(str_arr[f].equals("0001101")){
                    total += 0*plus;
                    just_total+=0;
                } else if (str_arr[f].equals("0011001")) {
                    total += 1*plus;
                    just_total+=1;
                } else if (str_arr[f].equals("0010011")) {
                    total += 2*plus;
                    just_total+=2;
                } else if (str_arr[f].equals("0111101")){
                    total += 3*plus;
                    just_total+=3;
                } else if (str_arr[f].equals("0100011")) {
                    total += 4*plus;
                    just_total+=4;
                } else if (str_arr[f].equals("0110001")){
                    total += 5*plus;
                    just_total+=5;
                } else if (str_arr[f].equals("0101111")){
                    total += 6*plus;
                    just_total+=6;
                }else if (str_arr[f].equals("0111011")){
                    total += 7*plus;
                    just_total+=7;
                } else if(str_arr[f].equals("0110111")){
                    total += 8*plus;
                    just_total+=8;
                } else {
                    total += 9*plus;
                    just_total+=9;
                }
            }
            if (total % 10 == 0) {
                System.out.println("#"+test_case+" "+just_total);
            }else {
                System.out.println("#"+test_case+" "+0);
            }
        }
    }
}