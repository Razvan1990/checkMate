package checking;

import com.google.common.collect.Multimap;
import util.PieceConstrains;


import java.util.*;

public class CheckMate extends ChessCheck {

    public void checkIfMate(Multimap<String, Integer> piecesMap) {

        PieceConstrains pieceConstrains = new PieceConstrains();
        int finalResult = 0;
        boolean isChessNow = checkIfChessPresent2(piecesMap);
        boolean checkNewBKwithWK = false;
        boolean containsWhiteKing = piecesMap.containsKey("white king");


        Collection<Integer> blackKingNumber = piecesMap.get("black king");
        int blackKingNumberPiece = 0;
        for (int i : blackKingNumber) {
            blackKingNumberPiece = i;
        }

        /**
         * TODO
         * 1. Find all squares for the king can move from chess -DONE
         * 2. IF IT IS CHECK, WE SHOULD delete the king number from the map -DONE
         * 3. Travel trough the whole list and add the new kingNumber every time in the map -DONE
         * 4. Check to see if there is check now again for all the positions -DONE
         * 5. Check to see if  is allowed on that square to put the king( kings to not be each other )
         * 6. if one condition for this is true then go to next piece, else if none is true, than we can break the loop cause it is not mate as there is no chess and
         * no king problems
         * 7. If it is check, delete the king number and add on the next loop the new king number and so on
         * 8. If all are check or king is near other king and cannot go on that squre, than we say it is mate. To do this, we somehow need to have a counter which in
         * the final should be equal to the size of the list for kingNumbers
         **/

        int[] rightSideValues = {16, 24, 32, 40, 48, 56};
        int[] leftSideValues = {9, 17, 25, 33, 41, 49, 57};
        int[] upSideValues = {2, 3, 4, 5, 6, 7};
        int[] downSideValues = {58, 59, 60, 61, 62, 63};
        int[] cornerValues = {1, 8, 57, 64};

        List<Integer> rightSideList = new ArrayList<>();
        List<Integer> leftSideList = new ArrayList<>();
        List<Integer> upSideList = new ArrayList<>();
        List<Integer> downSideList = new ArrayList<>();
        List<Integer> cornerList = new ArrayList<>();

        for (int i : rightSideValues) {
            rightSideList.add(i);
        }
        for (int i : leftSideValues) {
            leftSideList.add(i);
        }
        for (int i : upSideValues) {
            upSideList.add(i);
        }
        for (int i : downSideValues) {
            downSideList.add(i);
        }
        for (int i : cornerValues) {
            cornerList.add(i);
        }

        List<Integer> availableKingNumbers = kingsListSquares(blackKingNumberPiece, rightSideList, leftSideList, upSideList, downSideList, cornerList);


        if (isChessNow) {

            piecesMap.remove("black king", blackKingNumberPiece);

            for (int blackKingSquare : availableKingNumbers) {


                String piece = "";
                int temp = 0;

                    if(piecesMap.containsValue(blackKingSquare)){
                        piece = getKey(piecesMap, blackKingSquare);
                        piecesMap.remove(piece, blackKingSquare);
                        temp = blackKingSquare;

                    }
                piecesMap.put("black king", blackKingSquare);


                isChessNow = checkIfChessPresent2(piecesMap);

                if (containsWhiteKing) {
                    checkNewBKwithWK = pieceConstrains.checkingNewKingPosition(piecesMap, blackKingSquare);
                }


                if (isChessNow || (containsWhiteKing && checkNewBKwithWK)) {
                    finalResult = 2;

                } else {
                    finalResult = 1;
                    break;
                }

                piecesMap.remove("black king", blackKingSquare);
               if (!piece.equals("") && temp!=0) {
                   piecesMap.put(piece, temp);
               }


            }
        }

        manageResults(finalResult);


    }


    private List<Integer> kingsListSquares(int kingValue, List<Integer> list1, List<Integer> list2, List<Integer> list3, List<Integer> list4, List<Integer> list5) {
        List<Integer> kingsSquares = new ArrayList<>();
        int option = 0;
        if (list1.contains(kingValue)) {
            option = 1;
        } else if (list2.contains(kingValue)) {
            option = 2;
        } else if (list3.contains(kingValue)) {
            option = 3;
        } else if (list4.contains(kingValue)) {
            option = 4;
        } else if (list5.contains(kingValue)) {
            option = 5;
        }

        switch (option) {
            case 1:
                kingsSquares.add(kingValue - 8);
                kingsSquares.add(kingValue - 9);
                kingsSquares.add(kingValue - 1);
                kingsSquares.add(kingValue + 7);
                kingsSquares.add(kingValue + 8);
                break;
            case 2:
                kingsSquares.add(kingValue - 8);
                kingsSquares.add(kingValue - 7);
                kingsSquares.add(kingValue + 1);
                kingsSquares.add(kingValue + 9);
                kingsSquares.add(kingValue + 8);
                break;
            case 3:
                kingsSquares.add(kingValue - 1);
                kingsSquares.add(kingValue + 7);
                kingsSquares.add(kingValue + 8);
                kingsSquares.add(kingValue + 9);
                kingsSquares.add(kingValue + 1);
                break;
            case 4:
                kingsSquares.add(kingValue - 1);
                kingsSquares.add(kingValue - 9);
                kingsSquares.add(kingValue - 8);
                kingsSquares.add(kingValue - 7);
                kingsSquares.add(kingValue + 1);
                break;
            case 5:
                switch (kingValue) {
                    case 1:
                        kingsSquares.add(kingValue + 1);
                        kingsSquares.add(kingValue + 8);
                        kingsSquares.add(kingValue + 9);
                        break;
                    case 8:
                        kingsSquares.add(kingValue - 1);
                        kingsSquares.add(kingValue + 7);
                        kingsSquares.add(kingValue + 8);
                        break;
                    case 57:
                        kingsSquares.add(kingValue - 8);
                        kingsSquares.add(kingValue - 7);
                        kingsSquares.add(kingValue + 1);
                        break;
                    case 64:
                        kingsSquares.add(kingValue - 1);
                        kingsSquares.add(kingValue - 9);
                        kingsSquares.add(kingValue - 8);
                        break;
                }
                break;
            default:
                kingsSquares.add(kingValue - 9);
                kingsSquares.add(kingValue - 1);
                kingsSquares.add(kingValue + 7);
                kingsSquares.add(kingValue + 8);
                kingsSquares.add(kingValue + 9);
                kingsSquares.add(kingValue + 1);
                kingsSquares.add(kingValue - 7);
                kingsSquares.add(kingValue - 8);

        }

        return kingsSquares;
    }

    private void manageResults(int result) {
        switch (result) {
            case 0:
                System.out.println("No check then, no check mate");
                break;

            case 1:
                System.out.println("It is check, but it's not check mate");
                break;

            case 2:
                System.out.println("Check and check mate!!");
                break;

        }
    }

    public String getKey(Multimap<String, Integer> map, int value) {
        for (Map.Entry<String, Integer> entry : map.entries()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return "";
    }
}