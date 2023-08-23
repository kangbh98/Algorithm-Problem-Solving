import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int tiano = time / 4;
        for (int i=0;i<tiano;i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }

}