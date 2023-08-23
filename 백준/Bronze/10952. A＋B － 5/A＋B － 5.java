import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();
            if(number1 == 0 & number2 ==0){
                break;
            }
            int result = number1 + number2;
            System.out.println(result);
        }
        scanner.close();
    }
}