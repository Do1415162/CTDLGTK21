package Dequy;

public class cacBaiDeQuy {
	 public void chuyenNP(int n)
	  {
		  if(n!=0)
		  {
			  chuyenNP(n/2);
			  System.out.print(n%2);
		  }
	  }
	 public  int f(int n)
		{
			if((n==1)||(n==2)) return 1;
			else return f(n-1)+f(n-2);
		}
	 public int gthua(int n)
		{
			if( n==0)return 1;
			else return n*gthua(n-1);
		}
	 public int us(int a, int b)
	  {
		  if(a==b) return a;
		  else if(a>b) return us(a-b,b);
		  		else return us(a,b-a);
	  }
	 public int tong(int n)
		{
			if(n==1) return 1;
			else return n+tong(n-1);
		}
	
		public  int tongGthua(int n) 
		{
			if(n==1) return 1;
			else return gthua(n)+tongGthua(n-1);
		}
		public  int luyThua(int x, int n)
		{
			if(n==0)return 1;
			else return x*luyThua(x,n-1);
		}
		public  int tongLthua(int n)
		{
			if (n==1)return 1;
			else return luyThua(n,n)+tongLthua(n-1);
		}		
}
