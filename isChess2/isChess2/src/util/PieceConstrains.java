package util;

import com.google.common.collect.Multimap;

import java.util.Collection;

public class PieceConstrains {

    public boolean checkKingPositionsAreNotEachOther(Multimap<String, Integer> piecesMap, int blackKingPosition) {
        MathHelpers mathHelpers = new MathHelpers();
        boolean areNeighbourKings = false;
        if (piecesMap.containsKey("white king")) {
            Collection<Integer> whiteKingPosition = piecesMap.get("white king");
            int changeValue = 0;
            for (int value : whiteKingPosition) {
                changeValue = value;
            }

            if (mathHelpers.checkIfIsAllowedKing(changeValue, blackKingPosition)) {
                System.out.println("Kings cannot be positions each other on the board!Choose a new position for the black king");
                areNeighbourKings = true;
            } else {
                areNeighbourKings = false;
            }

        }
        return areNeighbourKings;

    }

    public boolean checkIfBishopsAreDifferentColor(Multimap<String, Integer> map, int firstBishop) {
        MathHelpers mathHelpers = new MathHelpers();
        boolean areDifferentColors = false;
        Collection<Integer> newBishopPosition = map.get("bishop");
        Integer [] convertedArray = newBishopPosition.toArray(new Integer[newBishopPosition.size()]);
        if(newBishopPosition.size()==2) {
            if (mathHelpers.checkIfIsAllowedBishops(firstBishop, convertedArray[0])) {
                System.out.println("Bishops must be on a different color");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

   public boolean checkIfMoreThan2Bishops(Multimap<String,Integer>map, String bishop){
       if(map.containsKey(bishop)){
           Collection<Integer>bishopNumbers = map.get(bishop);
           if(bishopNumbers.size()>1){
               return true;
           }
       }
       return false;
   }
}
