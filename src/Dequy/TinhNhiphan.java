package Dequy;

public class TinhNhiphan {

	
	// Hàm chính để chuyển đổi số thập phân sang nhị phân
    public static String decimalToBinary(int number) {
        if (number == 0) {
            return "0";
        } else if (number == 1) {
            return "1";
        } else {
            // Gọi đệ quy để chia số cho 2 và chuyển phần dư sang chuỗi nhị phân
            return decimalToBinary(number / 2) + (number % 2);
        }
    }
    
    public static void main(String[] args) {
        int number = 10; // Số thập phân cần chuyển đổi
        String binaryString = decimalToBinary(number);
        System.out.println("Số nhị phân của " + number + " là: " + binaryString);
    }

	   
	
}
