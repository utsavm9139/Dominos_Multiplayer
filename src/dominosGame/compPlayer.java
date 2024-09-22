//This acts as a computer player for the game.

package dominosGame;

import static dominoConsole.main.*;
import static dominoConsole.player.humanTurn;
import static dominoGUI.mainDisplay.guiMainBoolean;
import static dominoGUI.mainGUI.newList;
import static dominoGUI.mainDisplay.guiWinner;

public class compPlayer {

    public static void computerTurn(){

        turnComputer=true;
        System.out.println();

        mainGame playingDomino= new mainGame( 0,0,newList.get(0));
        System.out.println("Tray: "+ computer);
        System.out.println("Computer’s turn");

        int i=0;
        int counter=0;
        while(i< computer.size()){

            if(table.getDomino(table.size()-1).getNum2()==computer.getDomino(i).getNum1()){
                playingDomino= computer.getDomino(i);
                System.out.println("playing "+ playingDomino+ " at right.");
                table.addDomino(playingDomino);
                counter+=1;
            }else if (table.getDomino(table.size()-1).getNum2()==computer.getDomino(i).getNum2()){
                playingDomino= computer.getDomino(i);
                playingDomino.rotateDomino();
                counter+=1;
                System.out.println("playing "+ playingDomino+ " at right.");
                table.addDomino(playingDomino);
            }else if (table.getDomino(0).getNum1()==computer.getDomino(i).getNum2()){
                playingDomino= computer.getDomino(i);
                System.out.println("playing "+ playingDomino+ " at left.");
                counter+=1;
                table.addDomino(0,playingDomino);
            }else if(table.getDomino(0).getNum1()==computer.getDomino(i).getNum1()) {
                playingDomino = computer.getDomino(i);
                playingDomino.rotateDomino();
                System.out.println("playing " + playingDomino + " at left.");
                counter+=1;
                table.addDomino(0,playingDomino);
            }else if (computer.getDomino(i).getNum1()==0){
                playingDomino = computer.getDomino(i);
                System.out.println("playing " + playingDomino + " at right.");
                counter+=1;
                table.addDomino(playingDomino);
            }

            if(counter!=0){

                computer.removeDomino(i);
                break;
            }
            i+=1;
        }

        if(counter==0){
            computer.drawDomino(boneyard);
            computerTurn();
        }
        if(computer.size()==0|| human.size()==0 || boneyard.size()==0){
            winCheck(human,computer);
            gameover=true;
        }

        if(computer.size()==0|| human.size()==0 || boneyard.size()==0){
            guiWinner();
        }

        if(gameover==false &&guiMainBoolean==false) {
            humanTurn();
        }
    }



}