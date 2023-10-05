import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static Map<String,Integer> map = new HashMap<>();
    public static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String[][] clothes) {

        int total=1;
        
        for(int i = 0 ; i < clothes.length ;i++){
            String str = clothes[i][1];
            if(map.containsKey(str)){
                int num = map.get(str);
                num++;
                map.put(str,num);
            }else{
                map.put(str , 1);
                list.add(str);
            }
        }
        
        for(String key :list){
            int num = map.get(key);
            total*=num+1;
        }

        
        int answer = total-1;
        return answer;
    }
}