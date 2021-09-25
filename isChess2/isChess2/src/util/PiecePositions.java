package util;

import java.util.Scanner;

public class PiecePositions {

    public static char[] convertStringToCharArray(String s) {
        char[] myStringChar = s.toCharArray();
        return myStringChar;
    }

    public static int convertCharacterToAsciiCode(char c) {
        int characterNumber = (int) c;
        return characterNumber;
    }

    public static String piecePositioningOnTable(String piece){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select " +piece+ " position");
        String piecePosition = scanner.nextLine();
        char[] stringToCharacter = convertStringToCharArray(piecePosition);
        int charToAsciiFirst = convertCharacterToAsciiCode(stringToCharacter[0]);
        int charToAsciiLast = convertCharacterToAsciiCode(stringToCharacter[1]);
        while (piecePosition.length() > 2 || (charToAsciiFirst < 97 || charToAsciiFirst > 104) || charToAsciiLast < 49 || charToAsciiLast > 56) {
            System.out.println("Not a valid position. Please enter a correct position");
            piecePosition = scanner.nextLine();
            stringToCharacter = convertStringToCharArray(piecePosition);
            charToAsciiFirst = convertCharacterToAsciiCode(stringToCharacter[0]);
            charToAsciiLast = convertCharacterToAsciiCode(stringToCharacter[1]);
        }
        return piecePosition;
    }


}
