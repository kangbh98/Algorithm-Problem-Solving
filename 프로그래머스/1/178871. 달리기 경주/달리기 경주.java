import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> map = new HashMap<>();
    
        
        for(int i = 0 ; i < players.length ; i++){
            map.put(players[i],i);    
        }
        
        for(int i = 0 ; i < callings.length ; i++){
           int num = map.get(callings[i]);
           num--;
           map.put(callings[i],num);
           String str = players[num];
           players[num] = players[num+1];
           players[num+1] = str;
           num = map.get(str);
           num ++;
           map.put(str,num); 
        }
        
        String[] answer = new String[players.length];
        
        for(int i = 0 ; i < players.length ; i++){
            answer[i] = players[i];
        }
      
        return answer;
    }
}