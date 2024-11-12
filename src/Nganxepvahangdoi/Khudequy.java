package Nganxepvahangdoi;

public class Khudequy {

	public static void chuyen(int so)
	{Stack obj=new Stack();
	obj.init();
	while (so!=0)
	{
		obj.push(so%2);
		so=so/2;
		
	}
	boolean ok=true;
	while (ok)
	{ if (obj.top==-1) ok=false;
	else System.out.print(obj.pop());
	}
	}
	public static void main(String[] args ) {
		chuyen(11);

	}

}
