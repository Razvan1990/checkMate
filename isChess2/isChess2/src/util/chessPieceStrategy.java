package util;

public class chessPieceStrategy {

    public static int pieceNumberDifference(int a, int b) {
        int diff = Math.abs(a - b);
        return diff;
    }

    public static boolean checkCorrectPawnDifference(int a, int b) {
        if (b-a == 7 || b-a == 9) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean diagonalChess(int a) {
        if ((a % 7 == 0) || (a % 9 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean horizontalAndVeritcalChess(int diff) {
        if ((diff>=1 && diff<=8)||diff%8 ==0)  {
            return true;
        } else {
            return false;
        }
    }

    public static boolean knightChess(int a, int b) {
        if (pieceNumberDifference(a, b) == 6 || pieceNumberDifference(a, b) == 10 || pieceNumberDifference(a, b) == 15 || pieceNumberDifference(a, b) == 17) {
            return true;
        } else {
            return false;
        }

    }



}

