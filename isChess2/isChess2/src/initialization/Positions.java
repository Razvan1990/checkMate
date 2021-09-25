package initialization;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import pieces.PlayerPieces;
import piecesPositioning.ChoosePosition;
import util.PieceConstrains;
import util.PieceDouble;
import util.PiecePositions;

import java.util.*;

public class Positions extends PiecePositions {

    public String putKingOnTable(String king){
      return piecePositioningOnTable(king);

    }

    public Multimap<String,Integer> putOtherElementsOnTable (){

       // char[][] chessTable = new char[16][16];
     // List<Integer>tablePositionLists = new ArrayList<>();
        Multimap<String, Integer> tablePositionLists = ArrayListMultimap.create();
        Multimap<String, Integer> positionsElements = ArrayListMultimap.create();
        List<String> positionsList = new ArrayList<>();
        BoardPieces boardPieces = new BoardPieces();
        PieceDouble pieceDouble = new PieceDouble();
        PieceConstrains pieceConstrains = new PieceConstrains();
        ChoosePosition choosePosition = new ChoosePosition();
        String otherElements = boardPieces.addPieceOnBoard();
        List<String> finalOtherElements = boardPieces.introduceNewListElement(otherElements);




        for(String element:finalOtherElements){
            String piecePosition = piecePositioningOnTable(element);
          // positionsList.add(piecePosition);
            boolean isPositionFree = pieceDouble.checkIfPositionOfElementFree(piecePosition,positionsList);
            if(isPositionFree){
                piecePosition = piecePositioningOnTable(element);
                isPositionFree = pieceDouble.checkIfPositionOfElementFree(piecePosition,positionsList);
                //positionsList.add(piecePosition);
            }
            positionsList.add(piecePosition);
            String tablePiece = choosePosition.setPieceType(element);
            //oricum folosim in main
            int pieceBoardPosition = choosePosition.setPiecePositionInNumber(PlayerPieces.chessTable,tablePiece,piecePosition);
            tablePositionLists.put(element,pieceBoardPosition);
            positionsElements.put(piecePosition,pieceBoardPosition);
            boolean checkBishopNumbers = pieceConstrains.checkIfMoreThan2Bishops(tablePositionLists,"bishop");
            if(checkBishopNumbers && tablePiece.equals("b")){

                boolean checkBishopPositions = pieceConstrains.checkIfBishopsAreDifferentColor(tablePositionLists,pieceBoardPosition);
                while(checkBishopPositions){
                   tablePositionLists.remove(element,pieceBoardPosition);
                    pieceDouble.deleteBishopPosition(PlayerPieces.chessTable,"b",piecePosition,positionsElements,pieceBoardPosition);
                   positionsElements.remove(piecePosition,pieceBoardPosition);
                    piecePosition = piecePositioningOnTable("bishop");
                    isPositionFree = pieceDouble.checkIfPositionOfElementFree(piecePosition,positionsList);
                    while(isPositionFree){
                        piecePosition = piecePositioningOnTable("bishop");
                        isPositionFree = pieceDouble.checkIfPositionOfElementFree(piecePosition,positionsList);
                    }
                    positionsList.add(piecePosition);
                   // tablePositionLists.remove(element,pieceBoardPosition);
                    pieceBoardPosition = choosePosition.setPiecePositionInNumber(PlayerPieces.chessTable,tablePiece,piecePosition);
                    tablePositionLists.put(element, pieceBoardPosition);
                    positionsElements.put(piecePosition,pieceBoardPosition);
                    checkBishopPositions = pieceConstrains.checkIfBishopsAreDifferentColor(tablePositionLists,pieceBoardPosition);
                    System.out.println(checkBishopPositions);

                }
            }

        }
        return tablePositionLists;
    }







}
