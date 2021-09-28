package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChessPieceStrategy {

    public int pieceNumberDifference(int a, int b) {
        int diff = Math.abs(a - b);
        return diff;
    }

    public boolean checkCorrectPawnDifference(int a, int b) {
        if (b % 8 == 0 && (b - a == 9)) {
            return true;
        } else if ((b == 9 && (b - a == 7)) || (b == 17 && (b - a == 7)) || (b == 25 && (b - a == 7)) || (b == 33 && (b - a == 7)) ||
                (b == 41 && (b - a == 7)) || (b == 49 && (b - a == 7)) || (b == 57 && (b - a == 7))) {
            return true;
        } else if (b - a == 7 || b - a == 9) {
            return true;
        } else {
            return false;
        }
    }

    public boolean diagonalChess(int a, int b) {
        MathHelpers mathHelpers = new MathHelpers();
        int difference = pieceNumberDifference(a, b);
        HashMap<Integer, Integer> bishopMaps = mathHelpers.bishopsMap(PlayerPieces.chessBoardValues);
        if (((difference % 9 == 0 && a % 9 == 0 && b % 9 == 0) || (difference % 9 == 0 && a % 9 != 0 && b % 9 != 0) )
                && (bishopMaps.get(a).equals(bishopMaps.get(b))) && (a != b)) {
            return true;
        } else if (((difference % 7 == 0 && a % 7 == 0 && b % 7 == 0)  || (difference % 7 == 0 && a % 7 != 0 && b % 7 != 0))
                && (a != b) && (bishopMaps.get(a).equals(bishopMaps.get(b)))) {
            return true;
        } else if ((a == 56 && b == 63) || (a == 63 && b == 56)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean horizontalAndVeritcalChess(int a, int b) {
        int diff = pieceNumberDifference(a, b);
        if ((((diff >= 1 && diff <= 8) && (a >= 1 && a <= 8) && (b >= 1 && b <= 8)) || ((diff >= 1 && diff <= 8) && (a >= 9 && a <= 16) && (b >= 9 && b <= 16)) ||
                ((diff >= 1 && diff <= 8) && (a >= 17 && a <= 24) && (b >= 16 && b <= 24)) || ((diff >= 1 && diff <= 8) && (a >= 25 && a <= 32) && (b >= 25 && b <= 32)) ||
                ((diff >= 1 && diff <= 8) && (a >= 33 && a <= 40) && (b >= 33 && b <= 40)) || ((diff >= 1 && diff <= 8) && (a >= 41 && a <= 48) && (b >= 41 && b <= 48)) ||
                ((diff >= 1 && diff <= 8) && (a >= 49 && a <= 56) && (b >= 49 && b <= 56)) || ((diff >= 1 && diff <= 8) && (a >= 57 && a <= 64) && (b >= 57 && b <= 64)))
                ||
                (diff % 8 == 0 && a != b)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean knightChess(int a, int b) {
        if (pieceNumberDifference(a, b) == 6 || pieceNumberDifference(a, b) == 10 ||
                pieceNumberDifference(a, b) == 15 || pieceNumberDifference(a, b) == 17) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkForFalseChecks(int a, int b) {
        int[] notAcceptedValues = {8, 16, 24, 32, 40, 48, 56, 64, 17, 25, 33, 41, 49, 57};
        List<Integer> list = new ArrayList<>();
        for (int value : notAcceptedValues) {
            list.add(value);
        }
        if (list.contains(a) && list.contains(b)) {
            return false;
        }
        return true;
    }

    public boolean justHorizontalChess(int a, int b) {
        int diff = pieceNumberDifference(a, b);
        if (((diff >= 1 && diff <= 8) && (a >= 1 && a <= 8) && (b >= 1 && b <= 8)) || ((diff >= 1 && diff <= 8) && (a >= 9 && a <= 16) && (b >= 9 && b <= 16)) ||
                ((diff >= 1 && diff <= 8) && (a >= 17 && a <= 24) && (b >= 16 && b <= 24)) || ((diff >= 1 && diff <= 8) && (a >= 25 && a <= 32) && (b >= 25 && b <= 32)) ||
                ((diff >= 1 && diff <= 8) && (a >= 33 && a <= 40) && (b >= 33 && b <= 40)) || ((diff >= 1 && diff <= 8) && (a >= 41 && a <= 48) && (b >= 41 && b <= 48)) ||
                ((diff >= 1 && diff <= 8) && (a >= 49 && a <= 56) && (b >= 49 && b <= 56)) || ((diff >= 1 && diff <= 8) && (a >= 57 && a <= 64) && (b >= 57 && b <= 64))) {
            return true;

        } else {
            return false;
        }
    }

    public boolean jutVeritcalChess(int a, int b) {
        int diff = pieceNumberDifference(a, b);
        if (diff % 8 == 0 && a != b) {
            return true;
        } else {
            return false;
        }

    }


}





