package checking;

import com.google.common.collect.Multimap;
import util.chessPieceStrategy;

import java.util.Collection;

public class ChessCheck extends chessPieceStrategy {


    public boolean checkIfChessQueenKing(int kingNumber, int queenNumber) {

        int diffPos = pieceNumberDifference(kingNumber, queenNumber);
        return diagonalChess(diffPos) || horizontalAndVeritcalChess(diffPos);

    }

    public boolean checkIfChessPawnKing(int kingnumber, int pawnNumber) {
        return checkCorrectPawnDifference(kingnumber, pawnNumber);
    }

    public boolean checkIfChessKnightKing(int kingNumber, int knigthNumber) {
        return knightChess(kingNumber, knigthNumber);
    }

    public boolean checkIfChessRookKing(int kingNumber, int rookNumber) {
        int diffPos = pieceNumberDifference(kingNumber, rookNumber);
        return horizontalAndVeritcalChess(diffPos);
    }

    public boolean checkIfChessBishopKing(int kingNumber, int bishopNumber) {
        int difference = pieceNumberDifference(kingNumber, bishopNumber);
        return diagonalChess(difference);
    }

    public boolean checkIfChessPresent(Multimap<String, Integer> piecesList) {
        CheckingPiecesBetweenChess checkingPiecesBetweenChess = new CheckingPiecesBetweenChess();
        boolean isCheck = false;
        boolean freeRouteQueenKing = checkingPiecesBetweenChess.checkIfPieceBetweenQueenAndBlackKing
                (piecesList);
        Collection<Integer> blackKingNumberPositionCollection = piecesList.get("black king");
        int blackKingPosNumber = 0;
        for (int kingNumber : blackKingNumberPositionCollection) {
            blackKingPosNumber = kingNumber;
        }
        piecesList.remove("black king", blackKingPosNumber);
        for (String key : piecesList.keySet()) {
            switch (key) {
                case "queen":
                    Collection<Integer> queenCollection = piecesList.get(key);
                    for (int i : queenCollection) {

                        if (checkIfChessQueenKing(blackKingPosNumber, i) && freeRouteQueenKing) {
                            System.out.println("Check from " + key);
                            isCheck = true;
                        }
                    }
                    break;
                case "rook":
                    Collection<Integer> rookCollection = piecesList.get(key);
                    for (int i : rookCollection) {
                        if (checkIfChessRookKing(blackKingPosNumber, i)) {
                            System.out.println("Check from " + key);
                            isCheck = true;
                        }
                    }
                    break;

                case "bishop":
                    Collection<Integer> bishopCollection = piecesList.get(key);
                    for (int i : bishopCollection) {
                        if (checkIfChessBishopKing(blackKingPosNumber, i)) {
                            System.out.println("Check from " + key);
                            isCheck = true;
                        }
                    }
                    break;

                case "knight":
                    Collection<Integer> knightCollection = piecesList.get(key);
                    for (int i : knightCollection) {
                        if (checkIfChessKnightKing(blackKingPosNumber, i)) {
                            System.out.println("Check from " + key);
                            isCheck = true;
                        }
                    }
                    break;

                case "pawn":
                    Collection<Integer> pawnCollection = piecesList.get(key);
                    for (int i : pawnCollection) {
                        if (checkIfChessPawnKing(blackKingPosNumber, i)) {
                            System.out.println("Check from " + key);
                            isCheck = true;
                        }
                    }
                    break;
            }

        }
        piecesList.put("black king", blackKingPosNumber);
        return isCheck;
    }


}
