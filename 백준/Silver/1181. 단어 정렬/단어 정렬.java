import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[]= new String[n];
        for(int i = 0; i <n; i++){
            arr[i]= br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }else {
                    return o1.length()-o2.length();
                }
            }
        });
        String before= "안녕하십니까";
        for(int k=0;k<n;k++){
            if( !(arr[k].equals(before)) ){
                System.out.println(arr[k]);
                before = arr[k];
            }
        }
    }
}
