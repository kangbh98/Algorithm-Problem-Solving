import java.util.*;
import java.lang.*;
import java.io.*;


public class Main{

    public static String arr[];
    public static int k;

    public static ArrayList<String> list = new ArrayList();


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr= new String[k+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= k; i++) {
            arr[i] = st.nextToken();
        }

        int ans[] = new int[k + 1];
        boolean tf[] = new boolean[11];

        for (int i = 0; i < 10; i++) {
            tf[i]=true;
            ans[0] = i;
            Cal(tf,ans, 1);
            tf[i]=false;
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    public static void Cal(boolean[] tf, int[] ans,int depth){

        if (depth == k+1) {
            String s = "";
            for (int i = 0; i < k + 1; i++) {
                s = s + ans[i];
            }
            list.add(s);
            return;
        }



        for (int i = 0; i < 10; i++) {

            if(!tf[i]){
                String s = arr[depth];
                if( ( s.equals("<") && ans[depth-1] < i) || ( s.equals(">")&& ans[depth-1]>i)){
                    tf[i]=true;
                    ans[depth] = i;
                    Cal(tf, ans, depth+1);
                    tf[i]=false;
                }
            }
        }
    }
}