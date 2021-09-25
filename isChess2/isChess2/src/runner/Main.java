package runner;

import checking.ChessCheck;
import com.google.common.collect.Multimap;
import initialization.BoardPieces;
import initialization.Positions;
import initialization.Printing;
import pieces.PlayerPieces;
import piecesPositioning.ChoosePosition;
import util.PieceConstrains;
import util.PieceDouble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {

    public Positions positions;
    public Printing printing;
    public ChoosePosition choosePosition;
    public ChessCheck chessCheck;
    public BoardPieces boardPieces;

    public Main(Positions positions, Printing printing, ChoosePosition choosePosition, ChessCheck chessCheck, BoardPieces boardPieces) {
        this.printing = printing;
        this.positions = positions;
        this.choosePosition = choosePosition;
        this.chessCheck = chessCheck;
        this.boardPieces = boardPieces;
    }


    public static void main(String[] args) {
        try {
            Positions positions = new Positions();
            Printing printing = new Printing();
            ChoosePosition choosePosition = new ChoosePosition();
            ChessCheck chessCheck = new ChessCheck();
            BoardPieces boardPieces = new BoardPieces();
            PieceDouble pieceDouble = new PieceDouble();
            PieceConstrains pieceConstrains = new PieceConstrains();



            //  System.out.println(positions.kingPosition());

            String[][] chessTable = PlayerPieces.chessTable;
            //List<Integer> blackKingNumber = new ArrayList<>();
           // printing.showTable(chessTable);


            /**
             * USE THE NEW FUNCTION IN MAIN FROM POSITIONS-ok
             * METHOD TO NOT PUT THE BLACK KING AND WHITE KING NEAR-ok
             * METHOD TO NOT PUT THE BISHOPS ON SAME COLOR-OK
             * METHOD TO NOT PUT MORE THAN 2 WHITE KINGS-ok
             * USE THE LIST CREATED TO CHECK THE CHESSES-ok
             * MAKE METHOD TO CANCEL CHECK IF PIECE BETWEEN CHOSEN PIECE AND BLACK KING
             * MAKE METHOD FOR MATE
             */
            //must have the king position surely


//            for(int i =0;i<allBoardPieces.size();i++){
//
//            }
//            String queenPosition = positions.queenPosition();
            /* cred ca ne trebuie si o lista cu toate pozitiile acuma
            *de asemenea trebuie sa facem metoda pentru a vedea cum alegi sa fie sah in functie de piesa aleasa - tot un switch ceva
            * metoda de sah mat in functie de piese
             */


           // int queenNumber = choosePosition.setPiecePositionInNumber(chessTable, PlayerPieces.piecesArray[1], queenPosition);
           // blackKingNumber.add(kingNumber);
            printing.showTable(chessTable);
            Multimap<String,Integer> boardPiecesList = positions.putOtherElementsOnTable();
            String kingPosition = positions.putKingOnTable("black king");
            int kingNumber = choosePosition.setPiecePositionInNumber(chessTable, choosePosition.setPieceType("black king"), kingPosition);

            while(kingNumber ==0){
                kingPosition = positions.putKingOnTable("black king");
                kingNumber = choosePosition.setPiecePositionInNumber(chessTable, choosePosition.setPieceType("black king"), kingPosition);
            }
           boolean areKingsNeighbours = pieceConstrains.checkKingPositionsAreNotEachOther(boardPiecesList,kingNumber);
           while(areKingsNeighbours){
               pieceDouble.deleteBlackKingPosition(PlayerPieces.chessTable,"BK");
               kingPosition = positions.putKingOnTable("black king");
               printing.showTable(PlayerPieces.chessTable);
               kingNumber = choosePosition.setPiecePositionInNumber(chessTable, choosePosition.setPieceType("black king"), kingPosition);
               while(kingNumber ==0){
                   kingPosition = positions.putKingOnTable("black king");
                   kingNumber = choosePosition.setPiecePositionInNumber(chessTable, choosePosition.setPieceType("black king"), kingPosition);

               }
              // pieceDouble.deleteBlackKingPosition(PlayerPieces.chessTable,"BK");
               areKingsNeighbours= pieceConstrains.checkKingPositionsAreNotEachOther(boardPiecesList,kingNumber);
           }
          // kingNumber = choosePosition.setPiecePositionInNumber(chessTable, choosePosition.setPieceType("black king"), kingPosition);
           boardPiecesList.put("black king",kingNumber);
            //boolean checkBlackKIngPosition = pieceDouble.checkIfBlackKingHasFreePosition(boardPiecesList,kingNumber);
            for(String piece:boardPiecesList.keySet()){
                System.out.println(piece +":"+boardPiecesList.get(piece));
            }

//            while(checkBlackKIngPosition){
//                kingPosition = positions.putKingOnTable("black king");
//                kingNumber = choosePosition.setPiecePositionInNumber(chessTable, choosePosition.setPieceType("black king"), kingPosition);
//                checkBlackKIngPosition = pieceDouble.checkIfBlackKingHasFreePosition(boardPiecesList,kingNumber);
//            }
//            boardPiecesList.put("black king",kingNumber);
            printing.showTable(chessTable);
            boolean checkChess = chessCheck.checkIfChessPresent(boardPiecesList);


//            System.out.println("Is this position chess?");
//
//            Thread thread = new Thread();
//            thread.sleep(1500);
//
//            System.out.println(chessCheck.checkIfChessQueenKing(kingPosition, queenPosition, kingNumber, queenNumber));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}