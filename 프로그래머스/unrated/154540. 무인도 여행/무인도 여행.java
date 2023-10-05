import java.util.*;
import java.lang.*;


class MapPoint{
    int x;
    int y;
    
    public MapPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public static int n;
    public static int m;
    public static int arr[][];
    public static boolean tf[][];
    public static Queue<MapPoint> queue;
    
    public int[] solution(String[] maps) {
        
        n=maps.length;
        m=maps[0].length();
        arr= new int[n+1][m+1];
        tf = new boolean[n+1][m+1];
        queue = new LinkedList<MapPoint>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for( int i = 0 ; i < n; i++){
            String str = maps[i];
            for( int j = 0 ; j < m; j++){
                char ch = str.charAt(j);
                if(ch=='X'){
                    arr[i+1][j+1] = 0;
                }else{
                    arr[i+1][j+1] = ch-'0';
                }
            }
        }
        
        for(int i = 1 ; i <= n ; i++ ){
            for( int j = 1 ; j <= m; j++){
                int num = arr[i][j];
                if( num!=0 && !tf[i][j]){
                    tf[i][j]=true;
                    queue.add(new MapPoint(i,j));
                    list.add(Cal());
                }
            }
        }
        
        int[] answer;
        
        if(list.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
            return answer;          
        }else{
            answer = new int[list.size()];
            int i = 0;
            while(!list.isEmpty()){
                answer[i]=list.remove(0);
                i++;
            }
            Arrays.sort(answer);
            return answer;
        }
        
        
        
   
    }
    
    public static int Cal(){
        
        int num = 0;
        
        int arr1[] = {0,0,-1,1};
        int arr2[] = {-1,1,0,0};
        
        while(!queue.isEmpty()){
            
            MapPoint mp = queue.remove();
            
            int x = mp.x;
            int y = mp.y;
            num += arr[x][y];
                
            for( int i = 0 ; i < 4 ; i++){
                int x1 = x+arr1[i];
                int y1 = y+arr2[i];
                
                if( (x1>0 && x1<=n) && (y1>0 && y1<=m) && arr[x1][y1]!=0 && !tf[x1][y1]){
                    tf[x1][y1] = true;
                    queue.add(new MapPoint(x1,y1));
                }
            }
        }
        return num;
    }
}