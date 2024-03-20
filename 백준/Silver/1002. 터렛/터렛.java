import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; t++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            

            double turretDist= Math.sqrt(
                Math.abs(x1-x2)*Math.abs(x1-x2)+
                Math.abs(y1-y2)*Math.abs(y1-y2)
            ) + r1 + r2;

            if(x1 == x2 && y1 == y2 && r1==r2){
                System.out.println(-1);
                continue;
            }

            if(turretDist <= 2*r1 || turretDist <= 2*r2){
                turretDist -= r1+r2;
                if(turretDist+r1<r2 || turretDist+r2<r1){
                    System.out.println(0);                                               
                }else if(turretDist+r1>r2 && turretDist+r2>r1){
                    System.out.println(2);                                               
                }else{
                    System.out.println(1);                                               
                }
            }else{
                
                if(2*r1+2*r2 == turretDist){
                    System.out.println(1);              
                }else if(2*r1+2*r2 < turretDist){
                    System.out.println(0);               
                }else if(2*r1+2*r2 > turretDist){
                    System.out.println(2);              
                }
            }      
        }
    }
}