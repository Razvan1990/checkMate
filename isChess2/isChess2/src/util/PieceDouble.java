package util;

import com.google.common.collect.Multimap;

import java.util.*;

public class PieceDouble {

    public boolean checkIfPositionOfElementFree(String chosenPosition, List<String> boardPositionList) {
        if (boardPositionList.contains(chosenPosition)) {
            System.out.println("The position is already occupied by another piece! Please choose another position");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfBlackKingHasFreePosition(String[][] board, int x, int y) {
        if (board[x][y].equals(" ")) {
            return true;
        } else {
            System.out.println("Position already occupied!Please choose again");
            return false;
        }
    }

    public void deleteBlackKingPosition(String[][] chessTable, String kingPosition) {
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable.length; j++) {
                if (chessTable[i][j].equals(kingPosition)) {
                    chessTable[i][j] = " ";
                    break;
                }
            }
        }
    }

    public void deleteBishopPosition(String[][] chessTable, String bishop, String position, Multimap<String, Integer> map, int value) {

        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable.length; j++) {
                if (chessTable[i][j].equals(bishop) && checkPositionIsValue(map, value, position)) {
                    System.out.println("a intrat");
                    chessTable[i][j] = " ";
                    break;
                }
            }
        }
    }

    private boolean checkPositionIsValue(Multimap<String, Integer> map, int value, String position) {
        Collection<Integer> collection = map.get(position);
        int result = 0;
        for (int i : collection) {
            result = i;
        }
        collection.clear();
        if (result == value) {
            return true;
        } else {
            return false;
        }
    }



    public int checkNumberOfWhiteKings(List<String> list, String piece) {
        int numberOfWhiteKingOccurences = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(piece)) {
                numberOfWhiteKingOccurences++;
            }
        }
        return numberOfWhiteKingOccurences;
    }
}




