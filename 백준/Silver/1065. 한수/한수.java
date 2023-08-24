import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        if(n==1000) n--;

        if(n<100){
            System.out.println(n);
        }else{
            int k=0;
            for(int i=n;i>99;i--){
                
                String str=Integer.toString(i);
                int first_num = str.charAt(0)-'0';
                int second_num = str.charAt(1)-'0';
                int third_num = str.charAt(2)-'0';
                
                if((first_num+third_num)%2!=0) continue;
                if((first_num+third_num)/2==second_num){
                    k++;
                }
            }
            System.out.println(k+99);
        }
    }
}