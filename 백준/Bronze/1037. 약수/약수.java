import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = 1;//최댓값
        int num3 = 1000000;//최소값
        for(int i=0;i<num1;i++){
            int num4 = sc.nextInt();
                if(num4>num2){
                    num2=num4;
                }
                if(num4<num3){
                    num3=num4;
                }
        }
        System.out.println(num2*num3);
    }
}
