package Dequy;


public class baiKhuDeQuy {
	public int gthua(int n)
	{
		int i, gt=1;
		if (n==0)return 1;
		else 
		{
			for(i=1;i<n;i++) gt=gt*i;
			return gt;
		}
	}
	public int Fibo( int n)
	{
		int f1=1,f2=1,f=f1+f2;
		for(int i=3; i<=n; i++)
		{
			f1=f2;f2=f; f=f1+f2;
		}
		return f;
	}
		
		
	
}
