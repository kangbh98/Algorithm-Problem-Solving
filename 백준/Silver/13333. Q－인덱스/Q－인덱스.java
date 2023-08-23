import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int []arr=new int [N];

        for(int i = 0 ; i<N; i++){
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);
        for(int b = 0; b<=N; b++){
            /* 인용 횟수가 가장 적은 논문보다 Q 인덱스 값이 작거나
            안용횟수가 가장 큰 논문보다 Q인덱스 값이 클리가 없으니까,
            그 안 범위에서 모든 자연수를 넣는다. 그리고 조건 부합하는 것
            중에서 가장 큰 값을 답으로 내야하는거 같아서 역순으로 반복문 설정함*/
            int Low_k=0; // 논문 인용 횟수 K보다 작은 갯수
            int High_k=0; // 논문 인용 횟수 K 보다 많은 갯수
            for(int c=0; c<b; c++){
                if(arr[arr.length-1-c]>=b){
                    High_k++;
                }
            }
            for(int c=0; c<N-b; c++){
                if(arr[c]<=b){
                    Low_k++;
                }
            }
            //System.out.println(1);
            if(High_k==b && Low_k==N-b){
                //K 편 이상 인용된 논문이 K편 이상이고,
                //(K편 이하 인용된 논문의 갯수)는 {전체 갯수에서 (k편 이하 인용된 논문)을 뺀 값보다 크거나 같아야함}
                System.out.println(b);
                return;
            }
        }
    }

}
