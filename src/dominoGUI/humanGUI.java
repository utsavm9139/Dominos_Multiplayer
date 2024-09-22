//This sets up the GUI for the player side.

package dominoGUI;

import dominosGame.mainGame;
import javafx.scene.layout.HBox;
import static dominoGUI.mainDisplay.hBox;
import static dominoGUI.mainDisplay.finalHbox;
import static dominoConsole.main.*;
import static dominosGame.compPlayer.computerTurn;

public class humanGUI {
    public static void humanG(mainGame domino, char l_r){
        HBox hBox1= new HBox(10,domino.getHBox());
        hBox1.setRotate(180);
        mainGame rotateDomino= new mainGame(domino.getNum2(), domino.getNum1(), hBox1);
        System.out.println( "human : "+ human);

        if(l_r=='l'){
            if(validDomino(domino,table,l_r)==true){
                table.addDomino(0,domino);
                human.removeDomino(domino);
                System.out.println("Left clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }
            }else if(validDomino(rotateDomino,table,l_r)==true){
                table.addDomino(0,rotateDomino);
                human.removeDomino(domino);

                System.out.println("Left clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }


            }else{
                System.out.println("Not a valid domino on left");
                hBox.getChildren().clear();
                for(int i=0;i< human.size();i++){
                    hBox.getChildren().addAll(human.getDomino(i).getHBox());
                }
            }

        }else if(l_r=='r') {
            if(validDomino(domino,table,l_r)==true){
                table.addDomino(domino);
                human.removeDomino(domino);
                System.out.println("Right Clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }
            }else if(validDomino(rotateDomino,table,l_r)==true){
                table.addDomino(rotateDomino);
                human.removeDomino(domino);
                System.out.println("Right Clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }

            }else{

                System.out.println(" Not a valid domino on right.");
            }

        }


    }
}