package initialization;

import util.PieceDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardPieces {

    public String addPieceOnBoard() {
        String newElements = "";
        String comparingElement = "";
        Scanner scanner = new Scanner(System.in);

        while (newElements.equals("")) {
            System.out.println("Please choose what piece you would like added");

            String myPiece = scanner.nextLine();
            switch (myPiece) {
                case "pawn":
                    newElements = "pawn";
                    break;
                case "queen":
                    newElements = "queen";
                    break;
                case "knight":
                    newElements = "knight";
                    break;
                case "bishop":
                    newElements = "bishop";
                    break;
                case "rook":
                    newElements = "rook";
                    break;
                case "white king":
                    newElements = "white king";
                    break;
                default:
                    System.out.println("Not an existing piece! Please choose again");
                    break;

            }
        }


        return newElements;
    }

    public List<String> introduceNewListElement(String piece) {
        List<String> newElement = new ArrayList<>();
        PieceDouble pieceDouble = new PieceDouble();
        newElement.add(piece);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like a new piece added? Y-for yes, N-for no");

        checkAnswers(scanner, newElement);
        int numberOfWhiteKings = pieceDouble.checkNumberOfWhiteKings(newElement, "white king");

        boolean wereMoreThanTwoKings = false;
        while (numberOfWhiteKings > 1) {
            System.out.println("Just one king is allowed!Removing duplicate white kings");
            newElement.remove("white king");
            numberOfWhiteKings--;
            wereMoreThanTwoKings = true;
        }
        if (wereMoreThanTwoKings) {
            System.out.println("If you would like another piece added instead of kings? Y -for yes, N-for no");
            checkAnswers(scanner, newElement);
        }

        return newElement;
    }


    private void checkAnswers(Scanner scanner, List<String> newElement) {
        String answer = scanner.nextLine();


        while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n")) {
            System.out.println("Not a correct answer! Please choose again");
            answer = scanner.nextLine();
        }
        while (answer.toLowerCase().equals("y")) {
            //newElement = addPieceOnBoard();
            String chosenPiece = addPieceOnBoard();

            newElement.add(chosenPiece);
            System.out.println("Would you like a new piece added? Y-for yes, N-for no");
            answer = scanner.nextLine();
            while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n")) {
                System.out.println("Not a correct answer! Please choose again");
                answer = scanner.nextLine();

            }

        }
    }

}


