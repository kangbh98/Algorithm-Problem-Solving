import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int ans=0;
        int start=0;
        for(int a=0;a<str.length();a++){
            if(str.charAt(a)=='U'){
                ans++;
                start=a;
                break;
            }
        }

        for(int b= start;b<str.length();b++){
            if(str.charAt(b)=='C'){
                ans++;
                start=b;
                break;
            }
        }
        for(int c = start; c <str.length(); c++){
            if(str.charAt(c)=='P'){
                ans++;
                start= c;
                break;
            }
        }
        for(int d = start; d <str.length(); d++){
            if(str.charAt(d)=='C'){
                ans++;
                break;
            }
        }

        if(ans==4){
            System.out.println("I love UCPC");
        }
        else {
            System.out.println("I hate UCPC");
        }
    }
}
