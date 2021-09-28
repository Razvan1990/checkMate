package util;

import java.util.ArrayList;
import java.util.List;

public class MathHelpers {

    public boolean checkIfIsAllowedKing(int a, int b) {

        if (a == 1 && (a - b == -8 || a - b == -9 || a - b == -1)) {
            return true;
        } else if (a == 8 && (a - b == 1 || a - b == -7 || a - b == -8)) {
            return true;
        } else if (a == 57 && (a - b == 8 || a - b == 7 || a - b == -1)) {
            return true;
        } else if (a == 64 && (a - b == 8 || a - b == 9 || a - b == 1)) {
            return true;
        } else if ((a == 9 || a == 17 || a == 25 || a == 33 || a == 41 || a == 49) && (Math.abs(a - b) == 8 || a - b == -9 || a - b == -1 || a - b == 7)) {
            return true;
        } else if ((a == 16 || a == 24 || a == 32 || a == 40 || a == 48 || a == 56) && (Math.abs(a - b) == 8 || a - b == 9 || a - b == 1 || a - b == -7)) {
            return true;
        } else if ((a == 58 || a == 59 || a == 60 || a == 61 || a == 62 || a == 63) && (Math.abs(a - b) == 1 || a - b == 7 || a - b == 8 || a - b == 9)) {
            return true;
        } else if ((a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7) && (Math.abs(a - b) == 1 || a - b == -7 || a - b == -8 || a - b == -9)) {
            return true;
        } else if ((Math.abs(a - b) == 8 || Math.abs(a - b) == 1 || Math.abs(a - b) == 7 || Math.abs(a - b) == 9) && !trickyCheckNumbers(a)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfIsAllowedBishops(int a, int b) {
        ChessPieceStrategy chessPieceStrategy = new ChessPieceStrategy();
        int differenceBishops = chessPieceStrategy.pieceNumberDifference(a, b);
        HashMap<Integer,Integer> myMap = bishopsMap(PlayerPieces.chessBoardValues);
//         if ((a == 1 || b == 1) && (differenceBishops % 9 == 0)) {
//             return true;
//         }
//         if ((a == 8 || b == 8) && (differenceBishops % 7 == 0)) {
//             return true;
//         }
//         if ((a == 57 || b == 57) && (differenceBishops % 7 == 0)) {
//             return true;
//         }
//         if ((a == 64 || b == 64) && (differenceBishops % 9 == 0)) {
//             return true;
//         }

//         if (differenceBishops % 16 == 0) {
//             return true;
//         } else if (differenceBishops % 8 == 0) {
//             return false;
//         } else if (differenceBishops == 2 || differenceBishops == 4 || differenceBishops == 6) {
//             return true;
//         } else if (differenceBishops == 1 || differenceBishops == 3 || differenceBishops == 5) {
//             return false;
//         } else if (differenceBishops % 9 == 0) {
//             return true;
//         }else if((((a %2 ==0 && b %2!=0) ||(a%2!=0 && b %2 ==0)) && differenceBishops % 7==0) &&
//                     (((a %2 ==0 && b %2==0) ||(a %2 !=0 && b %2!=0)  && differenceBishops %14 ==0))){
         if((myMap.get(a)==PlayerPieces.colors[0] && myMap.get(b)==PlayerPieces.colors[0]) ||
                (myMap.get(a)==PlayerPieces.colors[1] && myMap.get(b)==PlayerPieces.colors[1])){
            return true;
            }
        else{
            return false;
        }
    }

    private boolean trickyCheckNumbers(int a) {
        List<Integer> myList = new ArrayList<>();
        int[] arrayOfBadValues = {1, 9, 17, 25, 33, 41, 49, 57, 8, 16, 24, 32, 40, 48, 56, 64};
        for (int i : arrayOfBadValues) {
            myList.add(i);
        }
        if (myList.contains(a)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean trickyBishops(int a, int b) {
        List<Integer> myList = new ArrayList<>();
        int[] arrayOfBadValues = {9, 17, 25, 33, 41, 49, 57, 8, 16, 24, 32, 40, 48, 56,2,3,4,5,6,7,58,59,60,61,62,63};
        for (int i : arrayOfBadValues) {
            myList.add(i);
        }
        if (myList.contains(a) || myList.contains(b)) {
            return false;
        } else {
            return true;
        }

    }
 public HashMap<Integer, Integer> bishopsMap(int [][]chessTableNumbers){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < chessTableNumbers.length; i++) {
            for (int j = 0; j < chessTableNumbers.length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        map.put(chessTableNumbers[i][j], 1);
                    } else {
                        map.put(chessTableNumbers[i][j], 0);
                    }
                } else {
                    if (j % 2 == 0) {
                        map.put(chessTableNumbers[i][j], 0);
                    } else {
                        map.put(chessTableNumbers[i][j], 1);
                    }
                }

            }
        }
        return map;
    }

}
