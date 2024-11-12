package Dequy;

public class solveNQueens {
    
    public static void solveNQueens(int n) {
        int[] board = new int[n];
        solveNQueensUtil(board, 0, n);
    }

    private static void solveNQueensUtil(int[] board, int row, int n) {
        if (row == n) {
            printSolution(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col; // Đặt quân hậu
                solveNQueensUtil(board, row + 1, n); // Đệ quy cho hàng tiếp theo
            }
        }
    }

    private static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row) {
                return false; // Kiểm tra cột và hai đường chéo
            }
        }
        return true;
    }

    private static void printSolution(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q "); // In quân hậu
                } else {
                    System.out.print(". "); // In ô trống
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4; // Bạn có thể thay đổi giá trị này để thử nghiệm với các kích thước khác
        System.out.println("Các giải pháp cho bài toán N-Queens với n = " + n + ":");
        solveNQueens(n);
    }
}
