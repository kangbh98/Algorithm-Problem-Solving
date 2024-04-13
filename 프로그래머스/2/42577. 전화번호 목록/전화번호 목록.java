import java.util.*;
import java.lang.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0 ; i < phone_book.length ; i++){
            
            String str = "";
            for(int j = 0 ; j < phone_book[i].length();j++){     
                str += phone_book[i].charAt(j);
                if(map.containsKey(str)){
                    return false;
                }
            }    
            map.put(phone_book[i],phone_book[i]);
            
        }
        
        
        return true;
    
        
    }
}