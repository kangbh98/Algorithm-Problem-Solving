import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            test_case = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            while (st.hasMoreElements()){
                int i = Integer.parseInt(st.nextToken());
                if(map.containsKey(i)){
                    Integer i1 = map.get(i);
                    i1++;
                    map.put(i, i1);
                }else {
                    map.put(i, 1);
                }
            }
            int max=0;
            int 최빈 =-1;
            for (Integer i : map.keySet()) {
                Integer i1 = map.get(i);
                if (i1 >= max) {
                    max =i1;
                    최빈 = i;
                }
            }
            System.out.println("#"+test_case+" "+최빈);
			map.clear();
        }
    }


}