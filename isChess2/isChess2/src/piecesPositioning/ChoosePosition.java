package piecesPositioning;

import pieces.PlayerPieces;
import util.PieceConstrains;
import util.PieceDouble;

import java.util.ArrayList;
import java.util.List;




public class ChoosePosition{



    public String setPieceType(String piece) {

        switch (piece) {
            case "white king":
                return "WK";
            case "queen":
                return "Q";
            case "knight":
                return "k";
            case "bishop":
                return "b";
            case "pawn":
                return "p";
            case "rook":
                return "r";
            case "black king":
                return "BK";
        }
        return "_";
    }


    public int setPiecePositionInNumber(String [][]chessTable,String tablePiece, String position) {
        PieceDouble pieceDouble = new PieceDouble();
        PieceConstrains pieceConstrains = new PieceConstrains();
        switch (position) {
            //1. randul 8
            case "a8":
               if(pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,1)) {
                   chessTable[1][1] = tablePiece;
                   return 1;
               }break;
            case "b8":
                if(pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,3)) {
                    chessTable[1][3] = tablePiece;
                    return 2;
                }break;
            case "c8":
                if(pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,5)) {
                    chessTable[1][5] = tablePiece;
                    return 3;
                }break;
            case "d8":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,7)) {
                    chessTable[1][7] = tablePiece;
                    return 4;
                }break;
            case "e8":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,9)) {
                    chessTable[1][9] = tablePiece;
                    return 5;
                }break;
            case "f8":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,11)) {
                    chessTable[1][11] = tablePiece;
                    return 6;
                }break;
            case "g8":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,13)) {
                    chessTable[1][13] = tablePiece;
                    return 7;
                }
            case "h8":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,1,15)) {
                    chessTable[1][15] = tablePiece;
                    return 8;
                }break;

            //2. randul 7
            case "a7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,1)) {
                    chessTable[3][1] = tablePiece;
                    return 9;
                }break;
            case "b7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,3)) {
                    chessTable[3][3] = tablePiece;
                    return 10;
                }break;
            case "c7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,5)) {
                    chessTable[3][5] = tablePiece;
                    return 11;
                }break;
            case "d7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,7)) {
                    chessTable[3][7] = tablePiece;
                    return 12;
                }break;
            case "e7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,9)) {
                    chessTable[3][9] = tablePiece;
                    return 13;
                }break;
            case "f7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,11)) {
                    chessTable[3][11] = tablePiece;
                    return 14;
                }break;
            case "g7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,13)) {
                    chessTable[3][13] = tablePiece;
                    return 15;
                }break;
            case "h7":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,3,15)) {
                    chessTable[3][15] = tablePiece;
                    return 16;
                }break;
            //3. randul 6
            case "a6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,1)) {
                    chessTable[5][1] = tablePiece;
                    return 17;
                }break;
            case "b6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,3)) {
                    chessTable[5][3] = tablePiece;
                    return 18;
                }break;
            case "c6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,5)) {
                    chessTable[5][5] = tablePiece;
                    return 19;
                }break;
            case "d6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,7)) {
                    chessTable[5][7] = tablePiece;
                    return 20;
                }break;
            case "e6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,9)) {
                    chessTable[5][9] = tablePiece;
                    return 21;
                }break;
            case "f6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,11)) {
                    chessTable[5][11] = tablePiece;
                    return 22;
                }break;
            case "g6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,13)) {
                    chessTable[5][13] = tablePiece;
                    return 23;
                }break;
            case "h6":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,5,15)) {
                    chessTable[5][15] = tablePiece;
                    return 24;
                }break;
            //4. randul 5
            case "a5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,1)) {
                    chessTable[7][1] = tablePiece;
                    return 25;
                }break;
            case "b5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,3)) {
                    chessTable[7][3] = tablePiece;
                    return 26;
                }break;
            case "c5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,5)) {
                    chessTable[7][5] = tablePiece;
                    return 27;
                }break;
            case "d5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,7)) {
                    chessTable[7][7] = tablePiece;
                    return 28;
                }break;
            case "e5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,9)) {
                    chessTable[7][9] = tablePiece;
                    return 29;
                }break;
            case "f5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,11)) {
                    chessTable[7][11] = tablePiece;
                    return 30;
                }break;
            case "g5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,13)) {
                    chessTable[5][13] = tablePiece;
                    return 31;
                }break;
            case "h5":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,7,15)) {
                    chessTable[7][15] = tablePiece;
                    return 32;
                }break;
            //5. randul 4
            case "a4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,1)) {
                    chessTable[9][1] = tablePiece;
                    return 33;
                }break;
            case "b4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,3)) {
                    chessTable[9][3] = tablePiece;
                    return 34;
                }break;
            case "c4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,5)) {
                    chessTable[9][5] = tablePiece;
                    return 35;
                }break;
            case "d4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,7)) {
                    chessTable[9][7] = tablePiece;
                    return 36;
                }break;
            case "e4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,9)) {
                    chessTable[9][9] = tablePiece;
                    return 37;
                }break;
            case "f4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,11)) {
                    chessTable[9][11] = tablePiece;
                    return 38;
                }break;
            case "g4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,13)) {
                    chessTable[9][13] = tablePiece;
                    return 39;
                }break;
            case "h4":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,9,15)) {
                    chessTable[9][15] = tablePiece;
                    return 40;
                }break;
            //6. randul 3
            case "a3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,1)) {
                    chessTable[11][1] = tablePiece;
                    return 41;
                }break;
            case "b3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,3)) {
                    chessTable[11][3] = tablePiece;
                    return 42;
                }break;
            case "c3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,5)) {
                    chessTable[11][5] = tablePiece;
                    return 43;
                }break;
            case "d3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,7)) {
                    chessTable[11][7] = tablePiece;
                    return 44;
                }break;
            case "e3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,9)) {
                    chessTable[11][9] = tablePiece;
                    return 45;
                }break;
            case "f3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,11)) {
                    chessTable[11][11] = tablePiece;
                    return 46;
                }break;
            case "g3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,13)) {
                    chessTable[11][13] = tablePiece;
                    return 47;
                }break;
            case "h3":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,11,15)) {
                    chessTable[11][15] = tablePiece;
                    return 48;
                }break;
            //7. randul 2
            case "a2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,1)) {
                    chessTable[13][1] = tablePiece;
                    return 49;
                }break;
            case "b2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,3)) {
                    chessTable[13][3] = tablePiece;
                    return 50;
                }break;
            case "c2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,5)) {
                    chessTable[13][5] = tablePiece;
                    return 51;
                }break;
            case "d2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,7)) {
                    chessTable[13][7] = tablePiece;
                    return 52;
                }break;
            case "e2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,9)) {
                    chessTable[13][9] = tablePiece;
                    return 53;
                }break;
            case "f2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,11)) {
                    chessTable[13][11] = tablePiece;
                    return 54;
                }break;
            case "g2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,13)) {
                    chessTable[13][13] = tablePiece;
                    return 55;
                }break;
            case "h2":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,13,15)) {
                    chessTable[13][15] = tablePiece;
                    return 56;
                }break;
            // 8. randul 1
            case "a1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,1)) {
                    chessTable[15][1] = tablePiece;
                    return 57;
                }break;
            case "b1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,3)) {
                    chessTable[15][3] = tablePiece;
                    return 58;
                }break;
            case "c1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,5)) {
                    chessTable[15][5] = tablePiece;
                    return 59;
                }break;
            case "d1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,7)) {
                    chessTable[15][7] = tablePiece;
                    return 60;
                }break;
            case "e1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,9)) {
                    chessTable[15][9] = tablePiece;
                    return 61;
                }break;
            case "f1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,11)) {
                    chessTable[15][11] = tablePiece;
                    return 62;
                }break;
            case "g1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,13)) {
                    chessTable[15][13] = tablePiece;
                    return 63;
                }break;
            case "h1":
                if (pieceDouble.checkIfBlackKingHasFreePosition(chessTable,15,15)) {
                    chessTable[15][15] = tablePiece;
                    return 64;
                }break;
            default:
                System.out.println("Something went wrong");


        }

        return 0;
    }

}

