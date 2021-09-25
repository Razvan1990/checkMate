package checking;

import com.google.common.collect.Multimap;
import util.chessPieceStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheckingPiecesBetweenChess extends chessPieceStrategy {

    //queen
    public boolean checkIfPieceBetweenQueenAndBlackKing(Multimap<String, Integer> piecesMap) {
        boolean isValidCheck = true;
        Collection<Integer> queenNumbers = piecesMap.get("queen");
        Collection<Integer> kingNumber = piecesMap.get("black king");

        int blackKingNumber = 0;
        for (int number : kingNumber) {
            blackKingNumber = number;
        }
        piecesMap.remove("black king", blackKingNumber);

        for (String key : piecesMap.keySet()) {
            System.out.print(key + " ");
        }

        for (String piece : piecesMap.keySet()) {
            if (queenNumbers != null && queenNumbers.size() >= 1) {
                for (int i : queenNumbers) {
                    int queenNumber = i;
                    int differenceQueenKing = pieceNumberDifference(blackKingNumber, queenNumber);
                    List<Integer> pieceList = getPieceListNumbers(piecesMap, piece);
                    if (!piece.equals("queen")) {
                        for (int k = 0; k < pieceList.size(); k++) {
                            int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, pieceList.get(k));
                            int differenceOtherPieceQueenNumber = pieceNumberDifference(pieceList.get(k), queenNumber);
                            if ((differenceOtherPieceKing < differenceQueenKing && differenceOtherPieceQueenNumber < differenceQueenKing)
                                    && (diagonalChess(differenceOtherPieceKing)
                                    || horizontalAndVeritcalChess(differenceOtherPieceKing))
                                    && (diagonalChess(differenceOtherPieceQueenNumber) ||
                                    horizontalAndVeritcalChess(differenceOtherPieceQueenNumber))) {
                                isValidCheck = false;
                            }

                        }

                    }
                    //int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, piecesMap.get(piece))
                }
            }
        }
        piecesMap.put("black king", blackKingNumber);
        return isValidCheck;

    }

    //rook
    public boolean checkIfPieceBetweenRookAndBlackKing(Multimap<String, Integer> piecesMap) {
        boolean isValidCheck = true;
        Collection<Integer> rookNumbers = piecesMap.get("queen");
        Collection<Integer> kingNumber = piecesMap.get("black king");

        int blackKingNumber = 0;
        for (int number : kingNumber) {
            blackKingNumber = number;
        }
        piecesMap.remove("black king", blackKingNumber);

        for (String piece : piecesMap.keySet()) {
            if (rookNumbers != null && rookNumbers.size() >= 1) {
                for (int i : rookNumbers) {
                    int rookNumber = i;
                    int differenceRookKing = pieceNumberDifference(blackKingNumber, rookNumber);
                    List<Integer> pieceList = getPieceListNumbers(piecesMap, piece);
                    for (int k = 0; k < pieceList.size(); k++) {
                        int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, pieceList.get(k));
                        int differenceOtherPieceRookNumber = pieceNumberDifference(pieceList.get(k), rookNumber);
                        if ((differenceOtherPieceKing < differenceRookKing && differenceOtherPieceRookNumber < differenceRookKing)
                                && horizontalAndVeritcalChess(differenceOtherPieceKing)) {
                            isValidCheck = false;

                        } else {
                            isValidCheck = true;
                        }


                    }
                    //int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, piecesMap.get(piece))
                }
            }
        }
        piecesMap.put("black king", blackKingNumber);
        return isValidCheck;

    }

    //bishop
    public boolean checkIfPieceBetweenbishopAndBlackKing(Multimap<String, Integer> piecesMap) {
        boolean isValidCheck = true;
        Collection<Integer> bishopNumbers = piecesMap.get("queen");
        Collection<Integer> kingNumber = piecesMap.get("black king");

        int blackKingNumber = 0;
        for (int number : kingNumber) {
            blackKingNumber = number;
        }
        piecesMap.remove("black king", blackKingNumber);

        for (String piece : piecesMap.keySet()) {
            if (bishopNumbers != null && bishopNumbers.size() >= 1) {
                for (int i : bishopNumbers) {
                    int bishopNumber = i;
                    int differenceBishopKing = pieceNumberDifference(blackKingNumber, bishopNumber);
                    List<Integer> pieceList = getPieceListNumbers(piecesMap, piece);
                    for (int k = 0; k < pieceList.size(); k++) {
                        int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, pieceList.get(k));
                        int differenceOtherPieceBishopNumber = pieceNumberDifference(pieceList.get(k), bishopNumber);
                        if ((differenceOtherPieceKing < differenceBishopKing && differenceOtherPieceBishopNumber < differenceBishopKing)
                                && horizontalAndVeritcalChess(differenceOtherPieceKing)) {
                            isValidCheck = false;

                        }


                    }
                    //int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, piecesMap.get(piece))
                }
            }
        }
        piecesMap.put("black king", blackKingNumber);
        return isValidCheck;

    }


    private List<Integer> getPieceListNumbers(Multimap<String, Integer> myMap, String pieceKey) {
        List<Integer> listElements = new ArrayList<>();
        Collection<Integer> collection = myMap.get(pieceKey);
        for (int i : collection) {
            listElements.add(i);
        }
        return listElements;
    }


}
