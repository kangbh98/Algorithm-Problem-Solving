import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        Queue<Integer> enemies = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int round = 1; round <= enemy.length; round++) {
            
            int e = enemy[round - 1];
            n -= e;
            enemies.offer(e);
            if (n < 0 && k > 0 && !enemies.isEmpty()) {
                n += enemies.poll();
                k--;
            } else if (n < 0) return round - 1;
        }
        return enemy.length;
    }
}