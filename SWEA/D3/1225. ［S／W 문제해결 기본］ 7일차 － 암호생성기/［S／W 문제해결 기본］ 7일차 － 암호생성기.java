import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{


    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String trash = br.readLine();
            st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            boolean flag = true;
            while (flag){
                for (int i = 1; i <= 5; i++) {
                    Integer remove = q.remove();
                    int i1 = remove - i;
                    if(i1<=0){
                        i1=0;
                        q.add(i1);
                        flag=false;
                        break;
                    }
                    q.add(i1);
                }
            }
            System.out.print("#"+test_case+" ");
            for (Integer i : q) {
                System.out.print(i+" ");
            }
            q.clear();
        }
    }


}