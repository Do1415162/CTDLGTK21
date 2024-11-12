package Nganxepvahangdoi;

import java.util.Stack;

public class bieuthuctiento {

    // Hàm kiểm tra xem ký tự có phải là toán tử không
    public static boolean laToanTu(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    // Hàm tính giá trị của phép toán dựa vào toán tử và hai toán hạng
    public static int thucHienPhepToan(char toanTu, int toanHang1, int toanHang2) {
        switch (toanTu) {
            case '+': return toanHang1 + toanHang2;
            case '-': return toanHang1 - toanHang2;
            case '*': return toanHang1 * toanHang2;
            case '/': return toanHang1 / toanHang2;
            default: return 0;
        }
    }

    // Hàm tính giá trị biểu thức tiền tố
    public static int tinhGiaTriTienTo(String bieuThuc) {
        Stack<Integer> nganXep = new Stack<>();
        
        // Duyệt từ phải sang trái
        for (int i = bieuThuc.length() - 1; i >= 0; i--) {
            char c = bieuThuc.charAt(i);
            
            // Nếu ký tự là số, đẩy vào ngăn xếp
            if (Character.isDigit(c)) {
                nganXep.push(c - '0'); // '0' là để chuyển đổi ký tự số thành số nguyên
            }
            // Nếu ký tự là toán tử, thực hiện phép tính
            else if (laToanTu(c)) {
                int toanHang1 = nganXep.pop();
                int toanHang2 = nganXep.pop();
                int ketQua = thucHienPhepToan(c, toanHang1, toanHang2);
                nganXep.push(ketQua);
            }
        }
        // Kết quả cuối cùng sẽ ở trên đỉnh ngăn xếp
        return nganXep.pop();
    }

    public static void main(String[] args) {
        String bieuThucTienTo = "*+23 5"; // Biểu thức: (2 + 3) * 5
        int ketQua = tinhGiaTriTienTo(bieuThucTienTo);
        System.out.println("Kết quả của biểu thức tiền tố: " + ketQua);
    }
}

