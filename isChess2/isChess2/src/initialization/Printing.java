package initialization;

import java.util.Arrays;

public class Printing {

    public void showTable (String [][] chessTable){
       for(int i =0;i< chessTable.length;i++){
           for(int j =0;j<chessTable.length;j++){
               System.out.print(chessTable[i][j]);
           }
           System.out.println();
        }
    }
}
