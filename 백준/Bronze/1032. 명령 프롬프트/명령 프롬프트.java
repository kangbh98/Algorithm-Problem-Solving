import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        String file = sc.next();
        int length = file.length();
        char [] word = file.toCharArray();

        for(int i=1;i<num1;i++){
            String file1 = sc.next();
            char [] word1 = file1.toCharArray();
            for(int j=0;j<length;j++){
                if(word[j]!=word1[j]){
                    word[j]= '?';
                }
            }
        }

        for(int k=0;k<word.length;k++){
            System.out.print(word[k]);
        }
    }
}