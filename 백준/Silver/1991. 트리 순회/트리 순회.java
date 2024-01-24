import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class node{

        Integer n;
        Integer left;
        Integer right;

        public node( Integer n,Integer left, Integer right) {
            this.n = n;
            this.left = left;
            this.right = right;
        }

    }

    public static node list[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new node[26];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = st.nextToken().charAt(0) - 'A';

            Integer num2 = st.nextToken().charAt(0) - 'A';
            if(num2<0) num2 = null;

            Integer num3 = st.nextToken().charAt(0) - 'A';
            if(num3<0) num3 = null;

            list[num1] = new node(num1,num2,num3);
        }

        preOrder(list[0]);
        System.out.println();
        middleOrder(list[0]);
        System.out.println();
        endOrder(list[0]);
    }

    public static void preOrder(node n) {
        System.out.print((char)('A'+n.n));
        if(n.left!=null){
            preOrder(list[n.left]);
        }
        if(n.right!=null){
            preOrder(list[n.right]);
        }
    }
    public static void middleOrder(node n) {
        if(n.left!=null){
            middleOrder(list[n.left]);
        }

        System.out.print((char)('A'+n.n));

        if(n.right!=null){
            middleOrder(list[n.right]);
        }
    }
    public static void endOrder(node n) {
        if(n.left!=null){
            endOrder(list[n.left]);
        }
        if(n.right!=null){
            endOrder(list[n.right]);
        }
        System.out.print((char)('A'+n.n));
    }
}
