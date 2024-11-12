package Dequy;

public class DemChuCai {
    public static int dem(String str, int n) {
        if (n == 0) {
            return 0;
        }
        return (Character.isLetter(str.charAt(n - 1)) ? 1 : 0) + dem(str, n - 1);
    }
}
