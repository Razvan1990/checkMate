package util;

public class MathHelpers {

    public boolean checkIfIsAllowedKing(int a, int b) {
        if (Math.abs(a - b) == 8 || Math.abs(a - b) == 1 || Math.abs(a - b) == 7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfIsAllowedBishops(int a, int b) {
        if (a % 2 == 0 & b % 2 == 0) {
            return true;
        } else if (a % 2 == 1 && b % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

}
