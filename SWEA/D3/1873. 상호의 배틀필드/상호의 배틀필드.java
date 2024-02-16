import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int H, W, N, x, y; // x, y: tank's init pos
    static String order;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()) + 1;

        for (int t = 1; t < T; t++) {
            sb.append('#').append(t).append(' ');

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();

                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        x = i;
                        y = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            order = br.readLine(); // input end

            for (int i = 0; i < N; i++) {
                if (order.charAt(i) != 'S')
                    move(order.charAt(i));
                else
                    shoot(map[x][y]);
            }

            for (char[] m : map) {
                for (char c : m) {
                    sb.append(c);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void move(char c) {
        if (c == 'U') {
            map[x][y] = '^';

            if (isFlat(c)) {
                map[x][y] = '.';
                map[--x][y] = '^';
            }
        } else if (c == 'D') {
            map[x][y] = 'v';

            if (isFlat(c)) {
                map[x][y] = '.';
                map[++x][y] = 'v';
            }
        } else if (c == 'L') {
            map[x][y] = '<';

            if (isFlat(c)) {
                map[x][y] = '.';
                map[x][--y] = '<';
            }
        } else {
            map[x][y] = '>';

            if (isFlat(c)) {
                map[x][y] = '.';
                map[x][++y] = '>';
            }
        }
    }

    public static void shoot(char c) {
        if (c == '^') {
            int tmpX = x - 1;

            while (tmpX > -1) {
                if (map[tmpX][y] == '#')
                    break;

                char tmp = map[tmpX][y];

                if (tmp != '-')
                    map[tmpX][y] = '.';

                if (tmp == '*')
                    break;

                tmpX--;
            }
        } else if (c == 'v') {
            int tmpX = x + 1;

            while (tmpX < H) {
                if (map[tmpX][y] == '#')
                    break;

                char tmp = map[tmpX][y];

                if (tmp != '-')
                    map[tmpX][y] = '.';

                if (tmp == '*')
                    break;

                tmpX++;
            }
        } else if (c == '<') {
            int tmpY = y - 1;

            while (tmpY > -1) {
                if (map[x][tmpY] == '#')
                    break;

                char tmp = map[x][tmpY];

                if (tmp != '-')
                    map[x][tmpY] = '.';

                if (tmp == '*')
                    break;

                tmpY--;
            }
        } else {
            int tmpY = y + 1;

            while (tmpY < W) {
                if (map[x][tmpY] == '#')
                    break;

                char tmp = map[x][tmpY];

                if (tmp != '-')
                    map[x][tmpY] = '.';

                if (tmp == '*')
                    break;

                tmpY++;
            }
        }
    }

    public static boolean isFlat(char c) {
        if (c == 'U') {
            if (x - 1 > -1 && map[x - 1][y] == '.')
                return true;
        } else if (c == 'D') {
            if (x + 1 < H && map[x + 1][y] == '.')
                return true;
        } else if (c == 'L') {
            if (y - 1 > -1 && map[x][y - 1] == '.')
                return true;
        } else {
            if (y + 1 < W && map[x][y + 1] == '.')
                return true;
        }

        return false;
    }
}
