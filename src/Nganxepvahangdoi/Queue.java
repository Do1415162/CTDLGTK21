package Nganxepvahangdoi;

public class Queue {
  int q[]; int n=10; int f=-1,l=-1;
  public void init()
  {
	  q=new int[10];
  }
  public void bS(int x)
  { if(l==n) System.out.println(" tran hang doi ");
  else if(l==-1) {f=0; l=0; q[l]=x;}
  else {l++; q[l]=x;}
}
public int lB()
{
	if(f==-1) return f;
	else if(f==l) { int x=q[f]; f=-1; l=-1; return x;}
	else {int x=q[f]; f++; return x;}
	}

}
    









