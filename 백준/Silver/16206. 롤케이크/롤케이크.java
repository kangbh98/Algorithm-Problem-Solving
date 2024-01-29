import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int count = 0;
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> arr10 = new PriorityQueue<>();
        ArrayList<Integer> arr12 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num%10 == 0 ){
                arr10.add(num);
            }else{
                arr12.add(num);
            }
        }

        while(m >0){

            if(!arr10.isEmpty()){
                Integer remove = arr10.remove();
                if(remove==10){
                    count++;
                }else if(remove ==20 ) {
                    count+=2;
                    m = m-1;
                }else{
                    arr10.add(remove-10);
                    count++;
                    m = m-1;
                }
            }else if(!arr12.isEmpty()){
                Integer remove = arr12.remove(0);

                if(remove>10) {
                    arr12.add(remove-10);
                    count++;
                    m= m-1;
                }

            }else{
                break;
            }

        }
        System.out.println(count);
    }
}