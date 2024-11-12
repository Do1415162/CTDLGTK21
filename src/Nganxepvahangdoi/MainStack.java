package Nganxepvahangdoi;

public class MainStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                 Stack obj=new Stack();
                 obj.init();
                 obj.push(7);
                 obj.push(5);
                 obj.push(3);
                 System.out.println(obj.pop()+"; "+obj.pop()+"; "+obj.pop());
	}

}
