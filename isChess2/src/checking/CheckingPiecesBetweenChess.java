package checking;

import com.google.common.collect.Multimap;
import util.ChessPieceStrategy;

import java.util.*;

public class CheckingPiecesBetweenChess extends ChessPieceStrategy {


    //queen
    public boolean checkIfPieceBetweenQueenAndBlackKing(Multimap<String, Integer> piecesMap) {

        boolean isValidCheck = true;
        Collection<Integer> queenNumbers = piecesMap.get("queen");
        Collection<Integer> kingNumber = piecesMap.get("black king");
        Set<Integer> numberPiecesNoCheck = new HashSet<>();
        HashMap<Integer, Integer> mapPiece = new HashMap<>();

        int blackKingNumber = 0;
        for (int number : kingNumber) {
            blackKingNumber = number;
        }
        piecesMap.remove("black king", blackKingNumber);


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
                                    && (diagonalChess(blackKingNumber, pieceList.get(k))
                                    || horizontalAndVeritcalChess(blackKingNumber, pieceList.get(k)))
                                    && (diagonalChess(pieceList.get(k), queenNumber) ||
                                    horizontalAndVeritcalChess(pieceList.get(k), queenNumber))) {

                                isValidCheck = false;
                                numberPiecesNoCheck.add(pieceList.get(k));
                            }

                        }

                    }
                    //int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, piecesMap.get(piece))
                }
            }
        }
        piecesMap.put("black king", blackKingNumber);
        int numberOfQueensCheck = 0;
        if (queenNumbers != null && numberPiecesNoCheck.size() != 0) {

            for (int queen : queenNumbers) {

                int differenceQueenBlackKing = pieceNumberDifference(blackKingNumber, queen);

                for (int numberNoCheckPiece : numberPiecesNoCheck) {
                    int differenceQueenBlockingPiece = pieceNumberDifference(queen, numberNoCheckPiece);

                    //ok for horizontal Chess and for vertical chess, but need to make 2 different methods
                    if (((justHorizontalChess(blackKingNumber, queen) || diagonalChess(blackKingNumber, queen))
                            && (differenceQueenBlackKing > differenceQueenBlockingPiece)
                            && (justHorizontalChess(numberNoCheckPiece, queen) || diagonalChess(numberNoCheckPiece, queen))) ||
                            ((jutVeritcalChess(blackKingNumber, queen) || diagonalChess(blackKingNumber, queen))
                                    && (differenceQueenBlackKing > differenceQueenBlockingPiece)
                                    && (jutVeritcalChess(numberNoCheckPiece, queen) || diagonalChess(numberNoCheckPiece, queen)))) {
                        //numberOfRooksCheck++;

                        mapPiece.put(queen, 1);

                    }
                }
            }
        }
        if (mapPiece.size() > 0) {
            for (int mapValue1 : mapPiece.keySet()) {
                queenNumbers.remove(mapValue1);
            }
        }

        if (queenNumbers != null && queenNumbers.size() > 0) {
            for (int remainingQueen : queenNumbers) {
                if (justHorizontalChess(blackKingNumber, remainingQueen) || diagonalChess(blackKingNumber, remainingQueen)) {
                    isValidCheck = true;
                }
                if(jutVeritcalChess(blackKingNumber,remainingQueen) || diagonalChess(blackKingNumber, remainingQueen)){
                    return true;
                }
            }
        }

        return isValidCheck;

    }


    //rook
    public boolean checkIfPieceBetweenRookAndBlackKing(Multimap<String, Integer> piecesMap) {
        boolean isValidCheck = true;
        int counterAppeareances = 0;
        Collection<Integer> rookNumbers = piecesMap.get("rook");
        Collection<Integer> kingNumber = piecesMap.get("black king");
        Set<Integer> numberPiecesNoCheck = new HashSet<>();
        HashMap<Integer, Integer> mapPiece2 = new HashMap<>();

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
                    if (!(piece.equals("rook")||piece.equals("queen"))) {
                        for (int k = 0; k < pieceList.size(); k++) {
                            int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, pieceList.get(k));
                            int differenceOtherPieceRookNumber = pieceNumberDifference(pieceList.get(k), rookNumber);
                            if (((differenceOtherPieceKing < differenceRookKing && differenceOtherPieceRookNumber < differenceRookKing)
                                    && horizontalAndVeritcalChess(blackKingNumber, pieceList.get(k))
                                    && horizontalAndVeritcalChess(pieceList.get(k), rookNumber)))
                                    {


                                isValidCheck = false;
                                numberPiecesNoCheck.add(pieceList.get(k));

                            }

                        }


                    }
                    //int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, piecesMap.get(piece))
                }
            }
        }
        piecesMap.put("black king", blackKingNumber);
//        if (rookNumbers != null) {
//            outerloop:
//            for (int rook : rookNumbers) {
//
//                for (int numberNoCheckPiece : numberPiecesNoCheck) {
//
//                    if (horizontalAndVeritcalChess(rook, numberNoCheckPiece)) {
//                        map.put(rook, 1);
//                        break outerloop;
//                    }
//                }
//            }
//        }
        int numberOfRooksCheck = 0;
        if (rookNumbers != null && numberPiecesNoCheck.size() != 0) {

            for (int rook : rookNumbers) {

                int differenceRookBlackKing = pieceNumberDifference(blackKingNumber, rook);

                for (int numberNoCheckPiece : numberPiecesNoCheck) {
                    int differenceRookBlockingPiece = pieceNumberDifference(rook, numberNoCheckPiece);

                    if ((horizontalAndVeritcalChess(blackKingNumber, rook)
                            && (differenceRookBlackKing > differenceRookBlockingPiece)
                            && horizontalAndVeritcalChess(numberNoCheckPiece, rook))) {
                        mapPiece2.put(rook, 1);

                    }
                }
            }
        }
        if (mapPiece2.size() > 0) {
            for (int mapValue1 : mapPiece2.keySet()) {
                rookNumbers.remove(mapValue1);
            }
        }

        if (rookNumbers != null && rookNumbers.size() > 0) {
            for (int remainingRook : rookNumbers) {
                if (horizontalAndVeritcalChess(blackKingNumber, remainingRook)) {
                    isValidCheck = true;

                }
            }
        }

        return isValidCheck;

    }

    //bishop
    public boolean checkIfPieceBetweenbishopAndBlackKing(Multimap<String, Integer> piecesMap) {
        boolean isValidCheck = true;
        int counterAppeareances = 0;
        Collection<Integer> bishopNumbers = piecesMap.get("bishop");
        Collection<Integer> kingNumber = piecesMap.get("black king");
        //for storing pieces which prevent checks
        Set<Integer> numberPiecesNoCheck = new HashSet<>();
        //map in which we put the bishopNumbers as key and 1 as a value just for value map
        HashMap<Integer, Integer> map = new HashMap<>();

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
                    if (!(piece.equals("bishop") || piece.equals("queen"))) {
                        for (int k = 0; k < pieceList.size(); k++) {
                            int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, pieceList.get(k));
                            int differenceOtherPieceBishopNumber = pieceNumberDifference(pieceList.get(k), bishopNumber);
                            if ((differenceOtherPieceKing < differenceBishopKing && differenceOtherPieceBishopNumber < differenceBishopKing)
                                    && diagonalChess(blackKingNumber, pieceList.get(k))
                                    && diagonalChess(pieceList.get(k), bishopNumber)) {
                                isValidCheck = false;
                                // counterAppeareances++;
                                numberPiecesNoCheck.add(pieceList.get(k));

                            }


                        }
                        //int differenceOtherPieceKing = pieceNumberDifference(blackKingNumber, piecesMap.get(piece))
                    }
                }
            }
        }
        piecesMap.put("black king", blackKingNumber);
//        int counterBishopChecks = 0;
//        if (bishopNumbers != null) {
//            for (int i : bishopNumbers) {
//                int diffKingBishops = pieceNumberDifference(blackKingNumber, i);
//                if (bishopNumbers.size() > counterAppeareances && diagonalChess(diffKingBishops)) {
//                    counterBishopChecks++;
//                    isValidCheck = true;
//                }
//            }
//
//            if (counterBishopChecks <= counterAppeareances){
//                isValidCheck = false;
//            }
        int numberOfBishopsCheck = 0;
        if (bishopNumbers != null && numberPiecesNoCheck.size() != 0) {

            for (int bishop : bishopNumbers) {

                int differenceBishopBlackKing = pieceNumberDifference(blackKingNumber, bishop);

                for (int numberNoCheckPiece : numberPiecesNoCheck) {
                    int differenceBishopBlockingPiece = pieceNumberDifference(bishop, numberNoCheckPiece);

                    if (diagonalChess(blackKingNumber, bishop)
                            && (differenceBishopBlackKing > differenceBishopBlockingPiece)
                            && diagonalChess(numberNoCheckPiece, bishop)) {
                        //numberOfRooksCheck++;
                        map.put(bishop, 1);

                    }
                }
            }
        }
        if (map.size() > 0) {
            for (int mapValue : map.keySet()) {
                bishopNumbers.remove(mapValue);
            }
        }

        if (bishopNumbers != null && bishopNumbers.size() > 0) {
            for (int remainingBishop : bishopNumbers) {
                if (diagonalChess(blackKingNumber, remainingBishop)) {
                    isValidCheck = true;
                }
            }
        }

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


