import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String str1 = in.next();
       String str =str1.toUpperCase();
       int[] arr = new int[26];
       int ans=0;
       int ans_phar=0;
       for(int i=0 ; i<str.length();i++){
           arr[str.charAt(i)-'A']++;
       }

       for(int k=0;k<26;k++){
           if(arr[k]>ans){
               ans=arr[k];
               ans_phar=k;
           }
       }
        Arrays.sort(arr);
        if(arr[25]==arr[24]){
            System.out.println("?");
            return;
        }
        System.out.println((char)(ans_phar+65));
    }
}
