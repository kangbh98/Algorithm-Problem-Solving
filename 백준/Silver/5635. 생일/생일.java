import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int N= in.nextInt();
        String Max_Name= " ";
        String Min_Name=" ";
        String Name;
        int []arr= new int[3];
        int Max_Order=0;
        int Min_Order=10000000;
        for(int i=0;i<N;i++){
            Name = in.next();
            arr[0]= in.nextInt();
            arr[1]= in.nextInt();
            arr[2]= in.nextInt();
            int order= ((2010-arr[2])*1000)+((12-arr[1])*100)+(31-arr[0]);
            if(order>Max_Order){
                Max_Order=order;
                Max_Name=Name;
            }
            if(order<Min_Order){
                Min_Order=order;
                Min_Name=Name;
            }
        }
        System.out.println(Min_Name);
        System.out.println(Max_Name);
    }

}