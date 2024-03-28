import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static char map[][];
    static int beaberMap[][];
    static int n,m;
    static int[] plusX = {-1,1,0,0};
    static int[] plusY = {0,0,-1,1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        beaberMap = new int[n][m];

        int startX = 0;
        int startY = 0;

        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = s.charAt(j);

                if(map[i][j]=='S'){
                    startX = i;
                    startY = j;
                }
            }
        }

//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < m ; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        bfs(startX,startY);
    }

    public static void bfs(int startX,int startY){

        beaberMap[startX][startY] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX,startY));

        while (!q.isEmpty()){

            int size = q.size();
            for(int i = 0 ; i < size ; i++){

                Node node = q.remove();
                int x = node.x;
                int y = node.y;
                if(map[x][y]=='D'){
                    System.out.println(beaberMap[x][y]);
                    System.exit(1);
                }

                for(int a = 0 ; a < 4 ; a++) {

                    int xd = x+plusX[a];
                    int yd = y+plusY[a];

                    if(xd>-1 && yd>-1 && xd <n && yd < m && map[x][y] != '*'&& map[xd][yd]!='*' && map[xd][yd]!='X' && beaberMap[xd][yd]==0){
                        beaberMap[xd][yd] = beaberMap[x][y]+1;
//                        map[xd][yd] = 'd';
                        q.add(new Node(xd,yd));
                        if(map[xd][yd]=='D'){
                            System.out.println(beaberMap[xd][yd]);
                            return;
                        }
                    }

                }
            }
            water();

//            for(int i = 0 ; i < n ; i++){
//                for(int j = 0 ; j < m ; j++){
//                    System.out.print(map[i][j]+" ");
//                 }
//            System.out.println();
//            }
//            System.out.println("------------------");
        }
        System.out.println("KAKTUS");
    }


    public static void water(){

        boolean waterMap[][] = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(map[i][j]=='*' && !waterMap[i][j]){

                    waterMap[i][j] =true;
                    for(int a = 0 ; a < 4 ; a++) {

                        int xd = i+plusX[a];
                        int yd = j+plusY[a];

                        if(xd>-1 && yd>-1 && xd <n && yd < m  && map[xd][yd]!='*' && map[xd][yd]!='X' && map[xd][yd]!='D'){
                            map[xd][yd] = '*';
                            waterMap[xd][yd] = true;
                        }

                    }
                }
            }
        }
    }
}