import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a=1;a<=n;a++){
            if(n%a==0){
                int c = n/a;
                for(int b=1;b<=n+2;b++){
                    if(-(n+2)%b==0){
                        int d = -(n+2)/b;
                        if(a*d+b*c==n+1){
                            System.out.println(a+" "+b+" "+c+" "+d);
                            return;
                        }
                    }

                }
            }
        }
        System.out.println(-1);
        return;

    }
}