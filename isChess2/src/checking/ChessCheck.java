package checking;

import com.google.common.collect.Multimap;
import util.ChessPieceStrategy;

import java.util.Collection;

public class ChessCheck extends ChessPieceStrategy {


    public boolean checkIfChessQueenKing(int kingNumber, int queenNumber) {


        return diagonalChess(kingNumber, queenNumber) || horizontalAndVeritcalChess(kingNumber,queenNumber);

    }

    public boolean checkIfChessPawnKing(int kingnumber, int pawnNumber) {
        return checkCorrectPawnDifference(kingnumber, pawnNumber);
    }

    public boolean checkIfChessKnightKing(int kingNumber, int knigthNumber) {
        return knightChess(kingNumber, knigthNumber);
    }

    public boolean checkIfChessRookKing(int kingNumber, int rookNumber) {
        //int diffPos = pieceNumberDifference(kingNumber, rookNumber);
        return horizontalAndVeritcalChess(kingNumber,rookNumber);
    }

    public boolean checkIfChessBishopKing(int kingNumber, int bishopNumber) {

        return diagonalChess(kingNumber, bishopNumber);
    }





        public boolean checkIfChessPresent(Multimap<String, Integer> piecesList) {
            CheckingPiecesBetweenChess checkingPiecesBetweenChess = new CheckingPiecesBetweenChess();
            boolean isCheck = false;
            boolean rookCheck = false;
            boolean bishopCheck = false;
            boolean queenCheck = false;

            int trackerOfChecks = 0;
            boolean freeRouteQueenKing = checkingPiecesBetweenChess.checkIfPieceBetweenQueenAndBlackKing
                    (piecesList);
            boolean freeRouteRookKing = checkingPiecesBetweenChess.checkIfPieceBetweenRookAndBlackKing(piecesList);
            boolean freeRouteBishopKing = checkingPiecesBetweenChess.checkIfPieceBetweenbishopAndBlackKing(piecesList);
            Collection<Integer> blackKingNumberPositionCollection = piecesList.get("black king");
            int blackKingPosNumber = 0;
            for (int kingNumber : blackKingNumberPositionCollection) {
                blackKingPosNumber = kingNumber;
            }
            piecesList.remove("black king", blackKingPosNumber);
            for (String key : piecesList.keySet()) {
                switch (key) {
                    case "queen":
                        isCheck = false;
                        Collection<Integer> queenCollection = piecesList.get(key);
                        for (int i : queenCollection) {

                            if (checkIfChessQueenKing(blackKingPosNumber, i) && freeRouteQueenKing) {
                                trackerOfChecks ++;
                                isCheck = true;
                                queenCheck = true;
                            }
                        }
                        if(isCheck){
                            System.out.println("Check from " + key);
                        }
                        break;
                    case "rook":
                        isCheck = false;
                        Collection<Integer> rookCollection = piecesList.get(key);
                        for (int i : rookCollection) {
                            if (checkIfChessRookKing(blackKingPosNumber, i) && freeRouteRookKing) {
                                trackerOfChecks ++;
                                isCheck = true;
                                rookCheck = true;
                            }
                        }

                        break;

                    case "bishop":
                        isCheck = false;
                        Collection<Integer> bishopCollection = piecesList.get(key);
                        for (int i : bishopCollection) {
                            if (checkIfChessBishopKing(blackKingPosNumber, i) && freeRouteBishopKing) {
                                isCheck = true;
                                trackerOfChecks++;
                                bishopCheck = true;
                            }
                        }



                        break;

                    case "knight":
                        isCheck = false;
                        Collection<Integer> knightCollection = piecesList.get(key);
                        for (int i : knightCollection) {
                            if (checkIfChessKnightKing(blackKingPosNumber, i)) {
                                trackerOfChecks++;
                                isCheck = true;
                            }
                        }
                        if(isCheck){
                            System.out.println("Check from " + key);
                        }
                        break;

                    case "pawn":
                        isCheck = false;
                        Collection<Integer> pawnCollection = piecesList.get(key);
                        for (int i : pawnCollection) {
                            if (checkIfChessPawnKing(blackKingPosNumber, i)) {
                                trackerOfChecks++;
                                isCheck = true;
                            }
                        }
                        if(isCheck){
                            System.out.println("Check from " + key);
                        }
                        break;
                }

            }
            piecesList.put("black king", blackKingPosNumber);

            if(bishopCheck && !queenCheck){
                System.out.println("Check from bishop!");
            }
            if(rookCheck && !queenCheck){
                System.out.println("Check from rook");
            }

            if(trackerOfChecks >0){
                isCheck = true;
            }
            return isCheck;
        }

        public boolean checkIfChessPresent2(Multimap<String, Integer> piecesList){
            CheckingPiecesBetweenChess checkingPiecesBetweenChess = new CheckingPiecesBetweenChess();
            boolean isCheck = false;
            int trackerOfChecks = 0;
            boolean freeRouteQueenKing = checkingPiecesBetweenChess.checkIfPieceBetweenQueenAndBlackKing
                    (piecesList);
            boolean freeRouteRookKing = checkingPiecesBetweenChess.checkIfPieceBetweenRookAndBlackKing(piecesList);
            boolean freeRouteBishopKing = checkingPiecesBetweenChess.checkIfPieceBetweenbishopAndBlackKing(piecesList);
            Collection<Integer> blackKingNumberPositionCollection = piecesList.get("black king");
            int blackKingPosNumber = 0;
            for (int kingNumber : blackKingNumberPositionCollection) {
                blackKingPosNumber = kingNumber;
            }
            piecesList.remove("black king", blackKingPosNumber);
            for (String key : piecesList.keySet()) {
                switch (key) {
                    case "queen":
                        isCheck = false;
                        Collection<Integer> queenCollection = piecesList.get(key);
                        for (int i : queenCollection) {
                            if (checkIfChessQueenKing(blackKingPosNumber, i) && freeRouteQueenKing) {
                                trackerOfChecks ++;

                            }
                        }

                        break;
                    case "rook":
                        isCheck = false;
                        Collection<Integer> rookCollection = piecesList.get(key);
                        for (int i : rookCollection) {
                            if (checkIfChessRookKing(blackKingPosNumber, i) && freeRouteRookKing) {
                                trackerOfChecks ++;

                            }
                        }

                        break;

                    case "bishop":
                        isCheck = false;
                        Collection<Integer> bishopCollection = piecesList.get(key);
                        for (int i : bishopCollection) {
                            if (checkIfChessBishopKing(blackKingPosNumber, i) && freeRouteBishopKing) {

                                trackerOfChecks++;
                            }
                        }


                        break;

                    case "knight":
                        isCheck = false;
                        Collection<Integer> knightCollection = piecesList.get(key);
                        for (int i : knightCollection) {
                            if (checkIfChessKnightKing(blackKingPosNumber, i)) {
                                trackerOfChecks++;

                            }
                        }


                    case "pawn":
                        isCheck = false;
                        Collection<Integer> pawnCollection = piecesList.get(key);
                        for (int i : pawnCollection) {
                            if (checkIfChessPawnKing(blackKingPosNumber, i)) {
                                trackerOfChecks++;
                                isCheck = true;
                            }
                        }

                        break;
                }

            }
            piecesList.put("black king", blackKingPosNumber);

            if(trackerOfChecks >0){
                isCheck = true;
            }
            return isCheck;
        }


    }

