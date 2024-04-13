import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] citations) {
        
        Integer cit[] = new Integer[citations.length];
        boolean visited[] = new boolean[citations.length];
        for(int i = 0 ; i < citations.length ; i++){
            cit[i] = citations[i];
        }
        
        Arrays.sort(cit,Collections.reverseOrder());
        int answer = 0;
        
        for(int i = 0 ; i < cit.length; i++){
            
            if(!visited[i]){
                int sameCount = 1;
                
                for( int j = i +1 ; j < cit.length ; j++){
                    if(cit[i]==cit[j]){
                        sameCount++;
                        visited[j] = true;
                    }else{
                        break;
                    }
                }
                
                
                int h = Math.min(cit[i],i+sameCount);
                answer = Math.max(answer,h);
                
                
            }
            
        }
        
        
        return answer;
    }
}