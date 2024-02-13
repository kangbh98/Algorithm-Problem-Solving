
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] inyoung, gyuyoung, picked;
    static boolean[] isSelected;
    static int win, lose, ans1, ans2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inyoung = new int[9];
            gyuyoung = new int[9];
            picked = new int[9];
            ans1 = 0;
            ans2 = 0;
            isSelected = new boolean[9];
            for (int i = 0; i < 9; i++) {
                inyoung[i] = Integer.parseInt(st.nextToken());
            }
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                boolean check = true;

                for (int iy : inyoung) {
                    if (i == iy) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    gyuyoung[idx++] = i;
                }
            }
            perm(0);
            System.out.println("#" + tc + " " + ans2 + " " + ans1);
        }
    }

    public static void perm(int count) {
        if (count == 9) {
            win = 0;
            lose = 0;

            for (int i = 0; i < 9; i++) {
                if (inyoung[i] > picked[i])
                    lose += inyoung[i] + picked[i];
                else
                    win += inyoung[i] + picked[i];
            }
            if (win > lose)
                ans1++;
            else if (win < lose)
                ans2++;

            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isSelected[i])
                continue;
            isSelected[i] = true;
            picked[count] = gyuyoung[i];
            perm(count + 1);
            isSelected[i] = false;
        }
    }
}
