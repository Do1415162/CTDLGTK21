package Nganxepvahangdoi;
  
public class MainQueue
{
	public static void main(String[] args) {
		Queue obj = new Queue();
		obj.init();
		obj.bS(5);
		obj.bS(7);
		System.out.println(obj.lB() + "; " + obj.lB() + "; " + obj.lB());
	}
}
