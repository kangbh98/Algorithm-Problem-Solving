import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int five_kg = n/5;
        int three_kg= 0;

        while(5*five_kg+3*three_kg!=n||five_kg<0){
            while(5*five_kg+3*three_kg<n){
                three_kg++;
            }
            if(5*five_kg+3*three_kg==n){
                break;
            }
            three_kg=0;
            five_kg--;
        }

        if(five_kg<0){
            System.out.println(-1);
        }else{
            System.out.println(five_kg+three_kg);
        }
    }
}
