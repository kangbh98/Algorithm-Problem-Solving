import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int ans=3;
		int[][][] dp=new int[N+1][2][3];
		dp[1][0][0]=1;
		dp[1][0][1]=1;
		dp[1][1][0]=1;
		
		for(int i=2;i<=N;i++) {
			dp[i][0][0]=dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2];
			dp[i][0][1]=dp[i-1][0][0];
			dp[i][0][2]=dp[i-1][0][1];
			dp[i][1][0]=ans;
			dp[i][1][1]=dp[i-1][1][0];
			dp[i][1][2]=dp[i-1][1][1];
			ans=0;
			for(int i2=0;i2<2;i2++) {
				for(int j2=0;j2<3;j2++){
					dp[i][i2][j2]%=1000000;
					ans+=dp[i][i2][j2];
				}
			}
			ans%=1000000;
		}
		System.out.println(ans);
   }
}